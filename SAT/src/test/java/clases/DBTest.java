/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevinj
 */
public class DBTest {

    private final String TABLA = "prueba";
    private final String CAMPOS = "atr1,atr2,atr3";
    private final Calendar TIEMPO = Calendar.getInstance();
    private final String VALORES = "5,'prueba','"
            + TIEMPO.get(Calendar.YEAR) + "-"
            + TIEMPO.get(Calendar.MONTH) + "-"
            + TIEMPO.get(Calendar.DAY_OF_MONTH) + "'";
    private final int[] TIPOS = {INT, STRING, STRING};

    private static final byte INT = 0;
    private static final byte DOUBLE = 1;
    private static final byte STRING = 2;
    private static final byte DATE = 3;
    private static final String[] DEF_TIPOS = {"entero", "decimal", "cadena", "fecha"};

    public DBTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of select method, of class DB.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        String campos = CAMPOS;
        String tablas = TABLA;

        String atributos[] = CAMPOS.split(",");
        String valores[] = VALORES.split(",");
        String condiciones = "";
        for (int i = 0; i < valores.length; i++) {
            condiciones += atributos[i] + "=" + valores[i] + " ";
            if (i < (valores.length - 1)) {
                condiciones += "and ";
            }
        }
        DB db = new DB();
        ArrayList result = db.select(campos, tablas, condiciones);
        if (result == null) {
            fail(db.getError());
        } else if (result.isEmpty()) {
            fail("DB.select: Devolvió resultado vacío.");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Object objeto = result.get(i);
                boolean interno = false;
                try {
                    switch (TIPOS[i]) {
                        case INT:
                            int intResultado = (int) objeto;
                            interno = true;
                            int intEsperado = Integer.parseInt(CAMPOS.split(",")[i]);
                            assertEquals(intResultado, intEsperado);
                            break;
                        case DOUBLE:
                            double doubleResultado = (double) objeto;
                            interno = true;
                            double doubleEsperado = Double.parseDouble(CAMPOS.split(",")[i]);
                            assertEquals(doubleResultado, doubleEsperado, 0.01);
                            break;
                        case STRING:
                        case DATE:
                            String stringResultado = objeto.toString();
                            interno = true;
                            String stringEsperado = (CAMPOS.split(",")[i]);
                            stringEsperado = stringEsperado.substring(1, stringEsperado.length() - 1);//SE HACE ESTO PORQUE TIENE LA COMILLA SIMPLE AL INICIO Y AL FINAL-> '
                            assertTrue(stringEsperado.equals(stringResultado));
                            break;
                    }
                } catch (NumberFormatException ex) {
                    if (interno) {
                        fail("DB.select: El tipo de dato " + DEF_TIPOS[TIPOS[i]] + " no es el indicado para el campo \"" + CAMPOS.split(",")[i] + "\"");
                    } else {
                        fail("DB.select: No coincide el resultado obtenido con el ingresado. Obtenido: " + String.valueOf(objeto) + ". Esperado: " + CAMPOS.split(",")[i]);
                    }
                }
            }
        }
    }

    /**
     * Test of insert method, of class DB.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String campos = CAMPOS;
        String tablas = TABLA;
        String valores = VALORES;
        DB db = new DB();
        if (db.insert(campos, tablas, valores)) {
            assertTrue(true);
        } else {
            fail(db.getError());
        }
    }

    /**
     * Test of delete method, of class DB.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String tablas = "";
        
        String atributos[] = CAMPOS.split(",");
        String valores[] = VALORES.split(",");
        String condiciones = "";
        for (int i = 0; i < valores.length; i++) {
            condiciones += atributos[i] + "=" + valores[i] + " ";
            if (i < (valores.length - 1)) {
                condiciones += "and ";
            }
        }
        DB db = new DB();
        if (db.delete(tablas, condiciones)) {
            assertTrue(true);
        } else {
            fail(db.getError());
        }
    }

    /**
     * Test of hasError method, of class DB.
     * @param db
     */
    @Test
    public void testHasError(DB db) {
        System.out.println("hasError");
        if(db.getError().equals("")){
            fail("El error está vacío, cuando debe especificar el por qué del error");
        }
    }

    /**
     * Test of getError method, of class DB.
     */
    @Test
    public void testGetError() {
        System.out.println("getError");
        DB instance = new DB();
        String expResult = "";
        String result = instance.getError();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
