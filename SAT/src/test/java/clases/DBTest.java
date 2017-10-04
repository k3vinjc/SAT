/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
            + (TIEMPO.get(Calendar.MONTH) + 1) + "-"
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
        if (db.insert(CAMPOS, TABLA, VALORES)) {
            if (db.delete(tablas, condiciones)) {
                assertTrue(true);
            } else {
                fail(db.getError());
            }
        } else {
            fail("DB.delete: No se pudo insertar el registro a eliminar.");
        }
        db.closeConnection();
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
        ArrayList<Object[]> result = db.select(CAMPOS, TABLA, condiciones, TIPOS);
        if (result == null) {
            fail(db.getError());
        } else if (result.isEmpty()) {
            fail("DB.select: Devolvió resultado vacío.");
        } else {
            String[] esperados = valores;
            for (Object[] registro : result) {
                for (int i = 0; i < registro.length; i++) {
                    Object campo = registro[i];
                    String esperado = esperados[i];
                    switch (TIPOS[i]) {
                        case DB.INT:
                            int intResultado = (int) (campo);
                            int intEsperado = Integer.parseInt(esperado);
                            assertEquals(intResultado, intEsperado);
                            break;
                        case DB.DOUBLE:
                            double doubleResultado = (double) campo;
                            double doubleEsperado = Double.parseDouble(esperado);
                            assertEquals(doubleResultado, doubleEsperado, 0.01);
                            break;
                        case DB.STRING:
                            String stringResultado = String.valueOf(campo);
                            String stringEsperado = esperado.substring(1, esperado.length() - 1);//SE HACE ESTO PORQUE TIENE LA COMILLA SIMPLE AL INICIO Y AL FINAL-> '
                            assertTrue(stringEsperado.equals(stringResultado));
                            break;
                        case DB.DATE:
                            Date dateResultado = (Date) campo;
                            Date dateEsperado = TIEMPO.getTime();
                            String txt_resultado = dateResultado.toString();
                            int mes,
                             dia;
                            mes = (TIEMPO.get(Calendar.MONTH) + 1);
                            dia = TIEMPO.get(Calendar.DAY_OF_MONTH);
                            String txt_esperado = +TIEMPO.get(Calendar.YEAR) + "-"
                                    + (mes<10? "0"+mes:""+mes) +"-"
                                    + (dia<10? "0"+dia:""+dia);
                            assertTrue(txt_esperado.equals(txt_resultado));
                            //assertTrue(dateEsperado.equals(dateResultado));
                            break;
                    }
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
}
