/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.sat;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kevinj
 */

public class DB {
    public static final boolean INT=true;
    public static final boolean DOUBLE=true;
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://www.sat.com/sat";
    private static final String USER = "root";
    private static final String PASS = "52525";

static Connection getConnection(){
	Connection con = null;
	try{
		con = DriverManager.getConnection(DB_URL, USER, PASS);
	} catch( SQLException ex){
		return null;
	}
	return con;
}

static ArrayList select(String campos, String tablas, String condiciones){
	Statement st;
	ResultSet rs;
        ArrayList al=null;
        Connection con;
	try{
                if((con=getConnection())==null)return null;
		st = con.createStatement();
		rs = st.executeQuery("select " + campos + " from " + tablas + (condiciones.isEmpty()?"":("where "+condiciones+";")));
                al=new ArrayList();
		while(rs.next()){
			//rs.getInt("nombre_campoINT");
			//rs.getString("campoString");
                        al.add(rs.toString());
		}
	}catch(SQLException ex){
		ex.printStackTrace();
	}
        return al;
}

static boolean insert(String campos, String tablas, String valores){
	Statement st;
        Connection con;
	try{
                if((con=getConnection())==null)return false;
		st = con.createStatement();
		if(st.executeUpdate("insert into "+tablas+"("+campos+") values ("+campos+");") >=1){
			return true;
		}
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	return false;
}
static boolean update(String tabla, String sets, String condiciones){
	Statement st;
        Connection con;
	try{
                if((con=getConnection())==null)return false;
		st = con.createStatement();
		if(st.executeUpdate("update "+tabla+" set "+sets+" where "+condiciones+";") >=1){
			return true;
		}
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	return false;
}

static boolean delete(String tablas, String condiciones){
	Statement st;
        Connection con;
	try{
                if((con=getConnection())==null)return false;
		st = con.createStatement();
		if(st.executeUpdate("delete from "+tablas+"where "+condiciones+";") >=1){
			return true;
		}
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	return false;
}
}