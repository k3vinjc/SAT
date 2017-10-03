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
    private final int[] TIPOS = {DB.INT, DB.DOUBLE, DB.STRING, DB.DATE};



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
        ArrayList result = db.select(CAMPOS, TABLA, condiciones,TIPOS);
        if (result == null) {
            fail(db.getError());
        } else if (result.isEmpty()) {
            fail("DB.select: Devolvió resultado vacío.");
        } else {
            Object objeto = result.get(0);
            String[] campos=CAMPOS.split(",");
            for (int i = 0; i < TIPOS.length; i++) {
                String campo = campos[i];
                try {
                    switch (TIPOS[i]) {
                        case DB.INT:
                            int intResultado = (int)(((java.sql.ResultSet) objeto).getObject(i+1));
                            int intEsperado = Integer.parseInt(campo);
                            assertEquals(intResultado, intEsperado);
                            break;
                        case DB.DOUBLE:
                            double doubleResultado = ((java.sql.ResultSet) objeto).getDouble(i+1);
                            double doubleEsperado = Double.parseDouble(campo);
                            assertEquals(doubleResultado, doubleEsperado, 0.01);
                            break;
                        case DB.STRING:
                            String stringResultado = ((java.sql.ResultSet) objeto).getString(i+1);
                            String stringEsperado = (campo);
                            stringEsperado = stringEsperado.substring(1, stringEsperado.length() - 1);//SE HACE ESTO PORQUE TIENE LA COMILLA SIMPLE AL INICIO Y AL FINAL-> '
                            assertTrue(stringEsperado.equals(stringResultado));
                            break;
                        case DB.DATE:
                            Date dateResultado = ((java.sql.ResultSet) objeto).getDate(i+1);
                            Date dateEsperado = TIEMPO.getTime();
                            assertTrue(dateEsperado.equals(dateResultado));
                            break;
                    }
                } catch (SQLException ex) {
                    fail("DB.select: No se encontró el campo: " + campo + " en el resultado de la consulta.");
                }
            }
        }
        db.closeConnection();
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
        db.closeConnection();
    }

    /**
     * Test of delete method, of class DB.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
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
        if (db.delete(tablas, condiciones)) {
            assertTrue(true);
        } else {
            fail(db.getError());
        }
        db.closeConnection();
    }

}
