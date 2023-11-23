/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class Mensajes_app {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do{
            
            System.out.println("---------------------------------------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear un mensaje.");
            System.out.println("2. Listar mensajes.");
            System.out.println("3. editar un mensaje.");
            System.out.println("4. eliminar un mensaje.");
            System.out.println("5. Salir.");
            
            //Leemos la opcion del usuario
            
            opcion = sc.nextInt();
            
        }while(opcion !=5);
        
        
    }
}
