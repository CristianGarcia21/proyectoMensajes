/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class mensajesService {
    
    public static void crearMensaje(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        
        System.out.println("Escriba su nombre: ");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        mensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        mensajesDAO.leerMensaje();
    }
    
    public static void borrarMensaje(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escibe el ID del mensaje que deseas borrar: ");
        int id_mensaje = sc.nextInt();
        mensajesDAO.borrarMensaje(id_mensaje);
    }
    
    public static void editarMensaje(){
        
    }
}
