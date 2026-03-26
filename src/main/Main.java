/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.io.*;
import java.util.Scanner;
import view.*;


public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    public final static String SALTO = System.getProperty("line.separator");
    final static String RUTA_PROYECTO = System.getProperty("user.dir");
    public final static String SEPARATOR = File.separator;
    
    public final static String RUTA_DATOS = RUTA_PROYECTO + SEPARATOR + "datos";
    public final static File CARPETA_DATOS = new File(RUTA_DATOS);
    
    public static VentanaPrincipal vPrincipal = new VentanaPrincipal();
    
    public static void main(String[] args) {
        
        try{
            if(!(CARPETA_DATOS.exists())){
                CARPETA_DATOS.mkdir();
            }
        }catch(Exception e) {
            System.err.println(e + "\n");
            sc.nextLine(); 
        }
        
        //Inicia ventana
        java.awt.EventQueue.invokeLater(() -> {
            vPrincipal.setVisible(true);
        });
       
        
    }
    
}
