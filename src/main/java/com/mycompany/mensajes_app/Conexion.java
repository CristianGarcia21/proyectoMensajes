/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Cristian
 */
public class Conexion {
    
    public Connection get_connection(){
        Connection conection = null;
        
            
        try{
            
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter?serverTimezone=UTC", "root" , "12345" );
            if (conection != null){
                System.out.println("Conexion Exitosa!");
            }
        }catch(SQLException e ){
            System.out.println(e);
        }
        return conection;
    }
}