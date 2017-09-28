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

        if (marca.isEmpty() || linea.isEmpty()) {
            error = true;
            txt_error = "El parámetro \"marca\" o \"linea\" vienen vacíos.";
        } else if ((costos = DB.select("factor", "marca", "marca='" + marca + "' and nombre='" + linea + "'")) == null) {
            error = true;
            txt_error = "Error de ejecución de consulta.";
        } else if (costos.size() > 1) {
            error = true;
            txt_error = "Doble factor para marca y línea.";
        } else if (costos.isEmpty()) {
            costo = getCosto(FACTOR_DEFECTO, modelo);
        } else {
            double factor;
            try {
                factor = ((java.sql.ResultSet) (costos.get(0))).getDouble("factor");
                costo = getCosto(factor, modelo);
            } catch (Exception ex) {
                error = true;
                txt_error = "Campo de \"factor\" incorrecto.";
                ex.printStackTrace();
            }
        }

        String Salida = "{\n"
                + "\"valor\" : " + String.valueOf(costo) + ",\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : " + txt_error + "\n"
                + "}";
        return Salida;
    }

    @WebMethod(operationName = "registro_Id_Compra")
    public String registro_Id_Compra(@WebParam(name = "id_Transferencia") int id_Transferencia, @WebParam(name = "monto_Compra") double monto_Compra) {
        String Salida = "";
        boolean error = false;
        String txt_error = "";
        if (monto_Compra < 0 || id_Transferencia < 0) {
            error = true;
            txt_error = "El monto y código de transferencia deben ser de valor positivo.";
        } else if (DB.insert("monto", "transferencia", "" + monto_Compra)) {
            error = true;
            txt_error = "Error de ejecución de consulta.";
        }

        Salida = "{\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : " + txt_error + "\n"
                + "}";
        return Salida;
    }

    @WebMethod(operationName = "guardar_Manifiesto")
    public String guardar_Manifiesto(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea, @WebParam(name = "modelo") String modelo, @WebParam(name = "fecha_Entrada") String fecha_Entrada, @WebParam(name = "pais_Origen") String pais_Origen) {
        String Salida;
        if (!marca.equals("") && !linea.equals("") && !modelo.equals("") && !fecha_Entrada.equals("") && !pais_Origen.equals("")) {
            Salida = "{\n"
                    + "\"num_Manifiesto\" : 0155 \n"
                    + "}";
        } else {
            Salida = "{\n"
                    + "\"num_Manifiesto\" : -1 \n"
                    + "}";
        }

        return Salida;
    }

    /*
        
     */
    @WebMethod(operationName = "guardar_Declaracion")
    public String guardar_Declaracion(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea, @WebParam(name = "modelo") int modelo, @WebParam(name = "precio") double precio, @WebParam(name = "fecha_declaracion") String fecha_declaracion) {
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
                if (!DB.insert("nombre", "marca", "'"+marca.toUpperCase()+"'")) {
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
                        if (!DB.insert("nombre,factor,marca", "linea", "'"+linea+"',"+FACTOR_DEFECTO+","+cod_marca)) {
                            error = true;
                            txt_error = "No se pudo agregar la linea no registrada.";
                        } else if ((consulta = DB.select("cod_linea", "linea", "marca = "+cod_marca+" and nombre = '" +linea+ "'")) == null) {
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

        Salida = "{\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : " + txt_error + "\n"
                + "}";
        return Salida;
    }
}
