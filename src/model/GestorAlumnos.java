/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.VentanaCurso;
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
    
    public static void eliminar(String curso, ArrayList<model.Alumno> alumnos) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(curso, false));
        for(model.Alumno alumno: alumnos){
            bw.write(alumno.toString());
            bw.write(salto);
        }
        bw.flush();
        bw.close();
    }
    
    public static ArrayList<model.Alumno> leer(String curso) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(curso));
        ArrayList<model.Alumno> alumnos = new ArrayList<>();
        String linea;
        while((linea = br.readLine()) != null){
            String[] dividido = linea.split(";");
            model.Alumno alumno = new model.Alumno(dividido[0], dividido[1], Integer.parseInt(dividido[2]), dividido[3]);
            alumnos.add(alumno);
        }
        br.close();
        return alumnos;
        
    }
    
    
}
