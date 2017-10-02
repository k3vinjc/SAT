/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private final String CAMPOS = "atr1,atr2,atr3,atr4";
    private final Calendar TIEMPO = Calendar.getInstance();
    private final String VALORES = "5,2.5,'prueba','"
            + TIEMPO.get(Calendar.YEAR) + "-"
            + TIEMPO.get(Calendar.MONTH) + "-"
            + TIEMPO.get(Calendar.DAY_OF_MONTH) + "'";
    private final int[] TIPOS = {INT, DOUBLE, STRING, DATE};

    private static final byte INT = 0;
    private static final byte DOUBLE = 1;
    private static final byte STRING = 2;
    private static final byte DATE = 3;
    private static final String[] DEF_TIPOS = {"entero", "decimal", "cadena", "fecha"};

    /*create table prueba(
	atr1 int not null,
	atr2 decimal(6,2) not null,
	atr3 varchar(30) not null,
	atr4 date
    );*/
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
                String campo = CAMPOS.split(",")[i];
                try {
                    switch (TIPOS[i]) {
                        case INT:
                            int intResultado = ((java.sql.ResultSet) objeto).getInt(campo);
                            interno = true;
                            int intEsperado = Integer.parseInt(campo);
                            assertEquals(intResultado, intEsperado);
                            break;
                        case DOUBLE:
                            double doubleResultado = ((java.sql.ResultSet) objeto).getDouble(campo);
                            interno = true;
                            double doubleEsperado = Double.parseDouble(campo);
                            assertEquals(doubleResultado, doubleEsperado, 0.01);
                            break;
                        case STRING:
                            String stringResultado = ((java.sql.ResultSet) objeto).getString(campo);
                            interno = true;
                            String stringEsperado = (campo);
                            stringEsperado = stringEsperado.substring(1, stringEsperado.length() - 1);//SE HACE ESTO PORQUE TIENE LA COMILLA SIMPLE AL INICIO Y AL FINAL-> '
                            assertTrue(stringEsperado.equals(stringResultado));
                            break;
                        case DATE:
                            Date dateResultado = ((java.sql.ResultSet) objeto).getDate(campo);
                            interno = true;
                            Date dateEsperado = TIEMPO.getTime();
                            assertTrue(dateEsperado.equals(dateResultado));
                            break;
                    }
                } catch (NumberFormatException ex) {
                    if (interno) {
                        fail("DB.select: El tipo de dato " + DEF_TIPOS[TIPOS[i]] + " no es el indicado para el campo \"" + CAMPOS.split(",")[i] + "\"");
                    } else {
                        fail("DB.select: No coincide el resultado obtenido con el ingresado. Obtenido: " + String.valueOf(objeto) + ". Esperado: " + CAMPOS.split(",")[i]);
                    }
                } catch (SQLException ex) {
                    fail("DB.select: No se encontró el campo: " + campo + " en el resultado de la consulta.");
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

}
