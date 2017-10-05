/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.sat;

import clases.DB;
import clases.Json;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevinj
 */
public class SATTest {

    public SATTest() {
    }

    /**
     * Test of calcular_Impuesto_Sat method, of class SAT.
     */
    @Test
    public void testCalcular_Impuesto_Sat() {
        System.out.println("calcular_Impuesto_Sat");
        String marca = "toyota";
        String linea = "hilux";
        int modelo = 2000;
        //FACTOR
        double factor = 101.26;
        Json json = new Json();
        json.addField("valor", (factor + (1000 / (java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - modelo)) + 200), DB.DOUBLE);
        json.addField("status", 0, DB.INT);
        json.addField("descripcion", "Calculo exitoso", DB.STRING);
        String expResult = json.toString();

        SAT instance = new SAT();
        String result = instance.calcular_Impuesto_Sat(marca, linea, modelo);

        if (!expResult.equals(result)) {
            Json reader = new Json(result);
            Object o = reader.getField("descripcion", DB.STRING);
            if (o != null) {
                fail("Resultado incorrecto. Descripción: " + (String) o);
            } else {
                fail("Resultado incorrecto. Descripción no parseada.");
            }
        } else {
            assertTrue(true);
        }
    }

    /**
     * Test of registro_Id_Compra method, of class SAT.
     */
    @Test
    public void testRegistro_Id_Compra() {
        System.out.println("registro_Id_Compra");
        int id_Transferencia = (int) ((new java.util.Random()).nextInt(20000) + 5000);
        double monto_Compra = id_Transferencia + 0.5;
        SAT instance = new SAT();

        String result = instance.registro_Id_Compra(id_Transferencia, monto_Compra);

        Json json = new Json();
        json.addField("status", 0, DB.INT);
        json.addField("descripcion", "Registrado", DB.STRING);
        String expResult = json.toString();

        if (!expResult.equals(result)) {
            Json reader = new Json(result);
            Object o = reader.getField("descripcion", DB.STRING);
            if (o != null) {
                fail("Resultado incorrecto. Descripción: " + (String) o);
            } else {
                fail("Resultado incorrecto. Descripción no parseada.");
            }
        } else {
            assertTrue(true);
        }
    }

    /**
     * Test of guardar_Manifiesto method, of class SAT.
     */
    @Test
    public void testGuardar_Manifiesto() {
        System.out.println("guardar_Manifiesto");
        String marca = "toyota";
        String linea = "hilux";
        int modelo = 2000;
        String fecha_Entrada = "2017-10-25";
        String pais_Origen = "Guatemala";
        SAT instance = new SAT();
        String result = instance.guardar_Manifiesto(marca, linea, modelo, fecha_Entrada, pais_Origen);

        //OBTENIENDO EL SUPUETO CÓDIGO GUARDADO
        int codigo;
        DB db = new DB();
        java.util.ArrayList<Object[]> datos = db.select("max(cod_manifiesto)", "manifiesto", "", new int[]{DB.INT});
        if (datos == null) {
            fail(db.getError());
        } else if (datos.size() < 1 && datos.get(0).length > 0) {
            fail("No se obtuvo datos sobre el manifiesto.");
        } else {
            codigo = (int) datos.get(0)[0];
            Json json = new Json();
            json.addField("num_Manifiesto", codigo, DB.INT);
            json.addField("status", 0, DB.INT);
            json.addField("descripcion", "Exitoso", DB.STRING);

            String expResult = json.toString();

            if (!expResult.equals(result)) {
                Json reader = new Json(result);
                Object o = reader.getField("descripcion", DB.STRING);
                if (o != null) {
                    fail("Resultado incorrecto. Descripción: " + (String) o);
                } else {
                    fail("Resultado incorrecto. Descripción no parseada.");
                }
            } else {
                assertTrue(true);
            }
        }
    }

    /**
     * Test of guardar_Declaracion method, of class SAT.
     */
    @Test
    public void testGuardar_Declaracion() {
        System.out.println("guardar_Declaracion");
        String marca = "toyota";
        String linea = "hilux";
        String fecha_declaracion = "2017-10-25";
        int modelo = 2000;
        double precio = ((double) ((int) (((new java.util.Random()).nextDouble()) * 50000))) / 100;//La última operación es para volverlo de 2 dígitos decimales
        SAT instance = new SAT();
        String result = instance.guardar_Declaracion(marca, linea, fecha_declaracion, modelo, precio);

        //OBTENIENDO EL SUPUETO CÓDIGO GUARDADO
        int codigo;
        DB db = new DB();
        java.util.ArrayList<Object[]> datos = db.select("max(cod_declaracion)", "declaracion", "", new int[]{DB.INT});
        if (datos == null) {
            fail(db.getError());
        } else if (datos.size() < 1 && datos.get(0).length > 0) {
            fail("No se obtuvo datos sobre la declaración.");
        } else {
            codigo = (int) datos.get(0)[0];
            Json json = new Json();
            json.addField("num_Declaracion", codigo, DB.INT);
            json.addField("status", 0, DB.INT);
            json.addField("descripcion", "Exitoso", DB.STRING);

            String expResult = json.toString();

            if (!expResult.equals(result)) {
                Json reader = new Json(result);
                Object o = reader.getField("descripcion", DB.STRING);
                if (o != null) {
                    fail("Resultado incorrecto. Descripción: " + (String) o);
                } else {
                    fail("Resultado incorrecto. Descripción no parseada.");
                }
            } else {
                assertTrue(true);
            }
        }
    }

}
