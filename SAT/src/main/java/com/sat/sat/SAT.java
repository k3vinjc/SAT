/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.sat;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author kevinj
 */
@WebService(serviceName = "SAT")
public class SAT {

    
    @WebMethod(operationName = "calcular_Impuesto_Sat")
    public String calcular_Impuesto_Sat(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea, @WebParam(name = "modelo") String modelo) {
        
        ArrayList costos = DB.select(marca, marca, modelo);
        
        String Salida="{\n" +
                        "\"valor\" : 400\n" +
                        "}";
        return Salida;
    }
    @WebMethod(operationName = "registro_Id_Compra")
    public String registro_Id_Compra(@WebParam(name = "id_Transferencia") int id_Transferencia, @WebParam(name = "monto_Compra") Double monto_Compra) {
        String Salida="";
        if(id_Transferencia != 0 && monto_Compra != 0){
            Salida ="{\n" +
                        "\"respuesta\" : \"true\" \n" +
                    "}";
        }else{
            Salida = "{\n" +
                        "\"respuesta\" : \"false\" \n" +
                    "}";
        }
        return Salida;
    }
    @WebMethod(operationName = "guardar_Manifiesto")
    public String guardar_Manifiesto(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea,@WebParam(name = "modelo") String modelo, @WebParam(name = "fecha_Entrada") String fecha_Entrada, @WebParam(name = "pais_Origen") String pais_Origen) {
        String Salida;
            if(!marca.equals("") && !linea.equals("") && !modelo.equals("") && !fecha_Entrada.equals("") && !pais_Origen.equals("")){
                Salida="{\n" +
                        "\"num_Manifiesto\" : 0155 \n" +
                        "}";
            }else{
                Salida="{\n" +
                        "\"num_Manifiesto\" : -1 \n" +
                        "}";
            }
                
        return Salida;
    }
    @WebMethod(operationName = "guardar_Declaracion")
    public String guardar_Declaracion(@WebParam(name = "marca") String marca, @WebParam(name = "linea") String linea,@WebParam(name = "modelo") String modelo, @WebParam(name = "precio") Double precio, @WebParam(name = "fecha_declaracion") String fecha_declaracion) {
        String Salida="";
        if(!marca.equals("") && !linea.equals("") && !modelo.equals("") && precio != 0 && !fecha_declaracion.equals("")){
            Salida ="{\n" +
                    "\"num_declaracion\" : 0123 \n" +
                    "}";
        }else{
            Salida ="{\n" +
                    "\"num_declaracion\" : -1 \n" +
                    "}";
            
        }
        return Salida;
    }
}
