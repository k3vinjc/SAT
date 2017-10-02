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

    public final boolean INT = true;
    public final boolean DOUBLE = true;
    private final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://www.sat.com:3306/sat";
    private final String USER = "root";
    private final String PASS = "52525";
    private String txt_error = "";
    private boolean error = false;

    private Connection getConnection() {
            Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            error=true;
            txt_error=ex.getMessage();
            return null;
        }
        return con;
    }

    public ArrayList select(String campos, String tablas, String condiciones) {
        Statement st;
        ResultSet rs;
        ArrayList al = null;
        Connection con;
        try {
            if ((con = getConnection()) == null) {
                return null;
            }
            st = con.createStatement();//"max(cod_manifiesto) as codman", "manifiesto", ""
            rs = st.executeQuery("select " + campos + " from " + tablas + (condiciones.trim().isEmpty() ? "" : ("where " + condiciones)) + ";");
            al = new ArrayList();
            while (rs.next()) {
                al.add(rs.toString());
            }
            con.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
            txt_error=ex.getMessage();
            error=true;
        }
        return al;
    }

    public boolean insert(String campos, String tablas, String valores) {
        Statement st;
        Connection con;
        try {
            if ((con = getConnection()) == null) {
                return false;
            }
            st = con.createStatement();
            if (st.executeUpdate("insert into " + tablas + "(" + campos + ") values (" + valores + ");") >= 1) {
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            txt_error=ex.getMessage();
            error=true;
        }
        return false;
    }

    public boolean update(String tabla, String sets, String condiciones) {
        Statement st;
        Connection con;
        try {
            if ((con = getConnection()) == null) {
                return false;
            }
            st = con.createStatement();
            if (st.executeUpdate("update " + tabla + " set " + sets + " where " + condiciones + ";") >= 1) {
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
            txt_error=ex.getMessage();
            error=true;
        }
        return false;
    }

    public boolean delete(String tablas, String condiciones) {
        Statement st;
        Connection con;
        try {
            if ((con = getConnection()) == null) {
                return false;
            }
            st = con.createStatement();
            if (st.executeUpdate("delete from " + tablas + "where " + condiciones + ";") >= 1) {
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
            txt_error=ex.getMessage();
            error=true;
        }
        return false;
    }

    public boolean hasError(){
        return error;
    }
    
    public String getError(){
        return txt_error;
    }
}
