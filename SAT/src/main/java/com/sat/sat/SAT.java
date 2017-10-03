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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
                + "\"valor\" : " + (error ? -1 : String.valueOf(getCosto(l.factor, modelo))) + ",\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : \"" + (error ? txt_error : "Calculo exitoso") + "\"\n"
                + "}";
        return salida;
    }

    @WebMethod(operationName = "registro_Id_Compra")
    public String registro_Id_Compra(@WebParam(name = "id_Transferencia") int id_Transferencia, @WebParam(name = "monto_Compra") double monto_Compra) {
        String salida = "";
        boolean error = false;
        String txt_error = "";
        DB db= new DB();
        if (monto_Compra < 0 || id_Transferencia < 0) {
            error = true;
            txt_error = "El monto y código de transferencia deben ser de valor positivo.";
        } else if (!db.insert("cod_transferencia,monto", "transferencia", id_Transferencia+"," + monto_Compra)) {
            error = true;
            txt_error = "Error de ejecución de insercion de transferencia.\nSQL error: "+db.getError();
        }
        salida = "{\n"
                + "\"status\" : " + (error ? 1 : 0) + ",\n"
                + "\"descripcion\" : \"" + (error ? txt_error : "Registrado") + "\"\n"
                + "}";
        return salida;
    }

    /*
        formato fecha_entrada: dd-mm-yyyy. Ejemplo: 28-02-2017
     */
    @WebMethod(operationName = "guardar_Manifiesto")
    public String guardar_Manifiesto(@WebParam(name = "marca") String marca, 
            @WebParam(name = "linea") String linea, 
            @WebParam(name = "modelo") int modelo, 
            @WebParam(name = "fecha_Entrada") String fecha_Entrada, 
            @WebParam(name = "pais_Origen") String pais_Origen) {
        String salida, txt_error = "";
        Manifiesto mn=null;
        boolean error=false;
        if (marca.trim().isEmpty() || linea.trim().isEmpty() || pais_Origen.trim().isEmpty() || fecha_Entrada.trim().isEmpty()) {
            error = true;
            txt_error = "Los campos \"marca\", \"linea\", \"país de origen\" y \"fecha de entrada\" no deben estar vacíos.";
        } else if (modelo < 1900) {
            error = true;
            txt_error = "El modelo del automóvil debe tener un valor válido. Mayor al año 1900";
        } else if((mn=new Manifiesto(marca, linea, modelo, fecha_Entrada, pais_Origen)).cod_manifiesto==0){
            error=true;
            txt_error=mn.getError();
        }

        salida = "{\n"
                + "\"num_Manifiesto\" : "+((error || mn==null)?"-1":mn.cod_manifiesto)+",\n"
                + "\"status\":"+(error?1:0)+",\n"
                + "\"descripcion\":\""+(error?txt_error:"Exitoso")+"\"\n"
                + "}";

        return salida;
    }

    /*
        
     */
    @WebMethod(operationName = "guardar_Declaracion")
    public String guardar_Declaracion(@WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "fecha_declaracion") String fecha_declaracion,
            @WebParam(name = "modelo") int modelo,
            @WebParam(name = "precio") double precio
    ) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = fecha_declaracion;//df.format(fecha_declaracion);
        boolean error = true;
        String txt_error = "", salida="";
        Declaracion d=null;

        if (marca.isEmpty() || linea.isEmpty() || fecha.isEmpty()) {
            txt_error = "El parámetro \"marca\", \"linea\" o \"fecha de declaración\" vienen vacíos.";
        } else if (modelo < 0 || precio < 0) {
            txt_error = "El modelo y precio de transferencia deben ser de valor positivo.";
        } else if((d=new Declaracion(marca, linea, modelo, precio, fecha)).cod_declaracion==0){
            txt_error=d.getError();
        }

        salida = "{\n"
                + "\"num_Manifiesto\" : "+((error || d==null)?"-1":d.cod_declaracion)+",\n"
                + "\"status\":"+(error?1:0)+",\n"
                + "\"descripcion\":\""+(error?txt_error:"Exitoso")+"\"\n"
                + "}";
        return salida;
    }
}