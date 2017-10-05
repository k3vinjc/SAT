/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kevinj
 */
public class DB {

    public static final byte INT = 0;
    public static final byte DOUBLE = 1;
    public static final byte STRING = 2;
    public static final byte DATE = 3;
    public static final String[] DEF_TIPOS = {"entero", "decimal", "cadena", "fecha"};

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";//com.mysql.jdbc.Driver
    private static final String DB_URL = "jdbc:mysql://www.sat.com:3306/sat";
    private static final String USER = "root";
    private static final String PASS = "52525";
    
    private String txt_error = "";
    private boolean error = false;
    private Connection con = null;

    private Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            error = true;
            txt_error = "Error de conexion a la BD: "+ex.getMessage();
            return null;
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
        }
    }

    public ArrayList<Object[]> select(String campos, String tablas, String condiciones, int[] tiposRespuesta) {
        Statement st;
        ResultSet rs;
        ArrayList registros = null;
        try {
            if ((con = getConnection()) == null) {
                return null;
            }
            st = con.createStatement();//"max(cod_manifiesto) as codman", "manifiesto", ""
            String query = "select " + campos + " from " + tablas + (condiciones.trim().isEmpty() ? "" : (" where " + condiciones)) + ";";
            rs = st.executeQuery(query);
            registros = new ArrayList();
            while (rs.next()) {
                Object[] valores=new Object[tiposRespuesta.length];
                for (int i = 0; i < tiposRespuesta.length; i++) {
                    switch(tiposRespuesta[i]){
                        case INT:
                            valores[i] = rs.getInt(i+1);
                            break;
                        case DOUBLE:
                            valores[i] = rs.getDouble(i+1);
                            break;
                        case STRING: default:
                            valores[i] = rs.getString(i+1);
                            break;
                        case DATE:
                            valores[i] = rs.getDate(i+1);
                            break;
                    }
                }
                registros.add(valores);
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            txt_error = ex.getMessage();
            error = true;
        }
        return registros;
    }

    public boolean insert(String campos, String tablas, String valores) {
        Statement st;
        try {
            if ((con = getConnection()) == null) {
                return false;
            }
            st = con.createStatement();
            if (st.executeUpdate("insert into " + tablas + "(" + campos + ") values (" + valores + ");") >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            txt_error = ex.getMessage();
            error = true;
        }
        return false;
    }

    /*public boolean update(String tabla, String sets, String condiciones) {
        Statement st;
        try {
            if ((con = getConnection()) == null) {
                return false;
            }
            st = con.createStatement();
            if (st.executeUpdate("update " + tabla + " set " + sets + " where " + condiciones + ";") >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            txt_error=ex.getMessage();
            error=true;
        }
        return false;
    }*/
    public boolean delete(String tablas, String condiciones) {
        Statement st;
        try {
            if ((con = getConnection()) == null) {
                return false;
            }
            st = con.createStatement();
            String query = "delete from " + tablas + " where " + condiciones + ";";
            if (st.executeUpdate(query) >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            txt_error = ex.getMessage();
            error = true;
        }
        return false;
    }

    public boolean hasError() {
        return error;
    }

    public String getError() {
        return txt_error;
    }
}
