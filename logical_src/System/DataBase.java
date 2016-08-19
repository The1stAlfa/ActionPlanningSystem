/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jordone3
 */
public class DataBase {
    private Connection con;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBMS = "mysql";
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "base_java";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public void DataBase(){
    }
    
    /*METODO CONECTAR*/
   
    public boolean connection ()throws Exception{
        try {
            Class.forName(DRIVER);
        }
        catch(ClassNotFoundException ce){
        }    
        try{
            this.con = DriverManager.getConnection("jdbc:" + DBMS + "://" 
                    + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);                                
            //System.out.println("CONEXION EXITOSA CON LA BASE DE DATOS");
            return true;
        }
        catch(SQLException exception){
            System.out.println("ERROR: NO SE PUDO CONECTAR CON LA BASE " 
                    + "DE DATOS: "+exception);
            return false;
        }
    }
    
    public boolean disconnection()
    {
        try{
            this.con.close();
            return(true);
        }
        catch(Exception e){
            return(false);
        }    
    }

    protected ResultSet selectQuery(String query) throws SQLException{
        Statement s = this.con.createStatement();
        ResultSet rs = s.executeQuery(query); 
        return rs;
    }
    
    protected boolean insertQuery(){
        return false;
    }
    
    protected boolean updateQuery(){
        return false;
    }
    
    protected boolean deleteQuery(){
        return false;
    }
}