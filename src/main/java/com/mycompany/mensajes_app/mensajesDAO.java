/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Cristian
 */
public class mensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
            
            PreparedStatement ps = null;
            
            try{
                String querry = "INSERT INTO twitter.mensajes (mensaje, autor_mensaje, fecha_mensaje)VALUES(?,?, CURRENT_TIMESTAMP())";
                ps = conexion.prepareStatement(querry);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensahe ha sido creado correctamente!");
                        
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensaje (){
        
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conexion = db_connect.get_connection()){
            
        String querry = "SELECT * FROM mensajes";
            
        ps = conexion.prepareStatement(querry);
        rs = ps.executeQuery();
        
        while(rs.next()){
            System.out.println("----------------------------------------------------");
            System.out.println("ID: "+rs.getInt("id_mensaje"));
            System.out.println("Mensaje: "+rs.getString("mensaje"));
            System.out.println("Autor: "+ rs.getString("autor_mensaje"));
            System.out.println("Fecha: "+ rs.getString("fecha_mensaje"));
            System.out.println("----------------------------------------------------");
        }
            
        }catch(SQLException e){
            System.out.println("");
            System.out.println("No se pudo recuperar los mensajes!!");
            System.out.println(e);
        }
    }
    
    public static void borrarMensaje(int id_mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                
                String querry = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(querry);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje borrado exitosamente!");
                
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("No es posible borrar el mensaje");
            }
            
        }catch(SQLException e){
            System.out.println("");
            System.out.println("No es posible conectar a db!!");
            System.out.println(e);
        }
    }
    
    public static void actualizarMensaje(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                String querry = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(querry);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizo correctamente");
                
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("No es posible actualizar el mensaje.");
                
            }
        }catch(SQLException e){
            System.out.println("");
            System.out.println("No es posible conectar a db!!");
            System.out.println(e);
        }
    }
}
