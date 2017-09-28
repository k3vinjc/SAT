/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.sat;

import clases.DB;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import clases.*;

/**
 *
 * @author kevinj
 */
@WebService(serviceName = "SAT")
public class SAT {

    private double getCosto(double factor, int modelo) {
        //Precio(“Marca, Linea”)+(1000/(AñoActual-Modelo+1))+200
        return factor + (1000 / (java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - modelo)) + 200;
    }

    @WebMethod(operationName = "calcular_Impuesto_Sat")
    public String calcular_Impuesto_Sat(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea, @WebParam(name = "modelo") int modelo) {
        boolean error = false;
        String txt_error = "";
        double costo = -1;
        ArrayList costos;
        Linea l = null;
        Marca m = null;

        if (marca.isEmpty() || linea.isEmpty()) {
            error = true;
            txt_error = "El parámetro \"marca\" o \"linea\" vienen vacíos.";
        } else {
            //ENCONTRANDO LA MARCA
            m = new Marca(marca);
            if (m.cod_marca == 0) {
                error = true;
                txt_error = m.getError();
            } else {
                //ENTONTRANDO LA LINEA PARA ESA MARCA
                l = new Linea(linea, m);
                if (l.cod_linea == 0) {
                    error = true;
                    txt_error = l.getError();
                }
            }
        }

        String salida = "{\n"
                + "\"valor\" : " + (error ? -1 : String.valueOf(l.factor)) + ",\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : " + (error ? txt_error : "Calculo exitoso") + "\n"
                + "}";
        return salida;
    }

    @WebMethod(operationName = "registro_Id_Compra")
    public String registro_Id_Compra(@WebParam(name = "id_Transferencia") int id_Transferencia, @WebParam(name = "monto_Compra") double monto_Compra) {
        String salida = "";
        boolean error = false;
        String txt_error = "";
        if (monto_Compra < 0 || id_Transferencia < 0) {
            error = true;
            txt_error = "El monto y código de transferencia deben ser de valor positivo.";
        } else if (DB.insert("monto", "transferencia", "" + monto_Compra)) {
            error = true;
            txt_error = "Error de ejecución de insercion de transferencia.";
        }
        salida = "{\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : " + (error ? txt_error : "Registrado") + "\n"
                + "}";
        return salida;
    }

    /*
        formato fecha_entrada: dd-mm-yyyy. Ejemplo: 28-02-2017
     */
    @WebMethod(operationName = "guardar_Manifiesto")
    public String guardar_Manifiesto(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea, @WebParam(name = "modelo") int modelo, @WebParam(name = "fecha_Entrada") String fecha_Entrada, @WebParam(name = "pais_Origen") String pais_Origen) {
        String salida, txt_error = "";
        Marca m = null;
        Linea l = null;
        boolean error;
        if (marca.trim().isEmpty() || linea.trim().isEmpty() || pais_Origen.trim().isEmpty() || fecha_Entrada.trim().isEmpty()) {
            error = true;
            txt_error = "Los campos \"marca\", \"linea\", \"país de origen\" y \"fecha de entrada\" no deben estar vacíos.";
        } else if (modelo < 1900) {
            error = true;
            txt_error = "El modelo del automóvil debe tener un valor válido. Mayor al año 1900";
        } else if ((m = new Marca(marca)).cod_marca == 0) {
            error = true;
            txt_error = m.getError();
        } else if ((l = new Linea(linea, m)).cod_linea == 0) {
            error = true;
            txt_error = l.getError();
        }else if (DB.insert("marca,linea,modelo,fecha_entrada,pais_origen", "manifiesto", m.cod_marca + "," + l.cod_linea + "," + modelo + ",'" + fecha_Entrada.trim() + "','" + pais_Origen.trim() + "'")) {
            error = true;
            txt_error = "Error de ejecución de insercion de manifiesto.";
        }

        salida = "{\n"
                + "\"num_Manifiesto\" : 155,\n"
                + "\"status\":0,\n"
                + "\"descripcion\":\"Exitoso\"\n"
                + "}";

        return salida;
    }

    /*
        
     */
    @WebMethod(operationName = "guardar_Declaracion")
    public String guardar_Declaracion(@WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "modelo") int modelo,
            @WebParam(name = "precio") double precio,
            @WebParam(name = "fecha_declaracion") String fecha_declaracion
    ) {
        String Salida = "";
        boolean error = false;
        String txt_error = "";
        int cod_marca = 0, cod_linea = 0;
        ArrayList consulta;

        if (marca.isEmpty() || linea.isEmpty() || fecha_declaracion.isEmpty()) {
            error = true;
            txt_error = "El parámetro \"marca\", \"linea\" o \"fecha de declaración\" vienen vacíos.";
        } else if (modelo < 0 || precio < 0) {
            error = true;
            txt_error = "El modelo y precio de transferencia deben ser de valor positivo.";
        } else if ((consulta = DB.select("cod_marca", "marca", "nombre = '" + marca.toUpperCase() + "'")) == null) {
            error = true;
            txt_error = "Error de ejecución de consulta de marca.";
        } else if (consulta.size() > 1) {
            error = true;
            txt_error = "Existen dos marcas con el mismo nombre.";
        } else {
            if (consulta.isEmpty()) {
                //NO EXISTE ESA MARCA, PREFERIBLEMENTE SE CREA
                if (!DB.insert("nombre", "marca", "'" + marca.toUpperCase() + "'")) {
                    error = true;
                    txt_error = "No se pudo agregar la marca no registrada.";
                } else if ((consulta = DB.select("cod_marca", "marca", "nombre = '" + marca.toUpperCase() + "'")) == null) {
                    error = true;
                    txt_error = "Error de ejecución de consulta de marca posterior a creación de marca.";
                } else if (consulta.size() > 1) {
                    error = true;
                    txt_error = "Existen dos marcas con el mismo nombre posterior a su creación.";
                } else if (consulta.isEmpty()) {
                    error = true;
                    txt_error = "No se pudo agregar la marca no registrada.";
                } else {
                    try {
                        cod_marca = ((java.sql.ResultSet) (consulta.get(0))).getInt("cod_marca");
                        //AGREGAR LA NUEVA LINEA
                        if (!DB.insert("nombre,factor,marca", "linea", "'" + linea + "'," + FACTOR_DEFECTO + "," + cod_marca)) {
                            error = true;
                            txt_error = "No se pudo agregar la linea no registrada.";
                        } else if ((consulta = DB.select("cod_linea", "linea", "marca = " + cod_marca + " and nombre = '" + linea + "'")) == null) {
                            error = true;
                            txt_error = "Error de ejecución de consulta de linea posterior a creación de linea y marca.";
                        } else if (consulta.size() > 1) {
                            error = true;
                            txt_error = "Existen dos lineas con el mismo nombre posterior a su creación.";
                        } else if (consulta.isEmpty()) {
                            error = true;
                            txt_error = "No se pudo agregar la linea no registrada. La marca sí fue registrada.";
                        } else {

                        }
                    } catch (Exception ex) {
                        error = true;
                        txt_error = "Campo \"cod_marca\" incorrecto o no encontrado en consulta.";
                        ex.printStackTrace();
                    }
                }
            } else if ((consulta = DB.select("cod_linea", "linea", "nombre = '" + marca + "'")) == null) {
                error = true;
                txt_error = "Error de ejecución de consulta de marca.";
            } else if (consulta.size() > 1) {
                error = true;
                txt_error = "Existen dos marcas con el mismo nombre.";
            } else if (consulta.isEmpty()) {
                costo = getCosto(FACTOR_DEFECTO, modelo);
            } else {
                double factor;
                try {
                    factor = ((java.sql.ResultSet) (consulta.get(0))).getDouble("factor");
                    costo = getCosto(factor, modelo);
                } catch (Exception ex) {
                    error = true;
                    txt_error = "Campo de \"factor\" incorrecto.";
                    ex.printStackTrace();
                }
            }
        }

        salida = "{\n"
                + "\"num_declaracion\" : 123,\n"
                + "\"status\":0,\n"
                + "\"descripcion\":\"Exitoso\"\n"
                + "};";
        return salida;
    }
}
