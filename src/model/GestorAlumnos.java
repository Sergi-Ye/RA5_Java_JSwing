/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import main.Main;
import java.io.*;
import java.util.ArrayList;
import view.VentanaCurso;
import view.VentanaPrincipal;

/**
 *
 * @author Joan
 */
public class GestorAlumnos {
    static String salto = System.getProperty("line.separator");
    
    public static void añadir(String curso, model.Alumno alumno) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(curso, true));
        bw.write(alumno.toString());
        bw.write(salto);
        bw.flush();
        bw.close();
    }
    
    public static String leer(String curso) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(curso));
        ArrayList<model.Alumno> alumnos = new ArrayList<>;
        String linea;
        while((linea = br.readLine()) != null){
            contenido += linea + "\n";
        }
        br.close();
        return contenido;
        
    }
    
    
}
