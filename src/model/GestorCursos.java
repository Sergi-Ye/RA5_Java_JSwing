/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import main.Main;
/**
 *
 * @author Joan
 */
public class GestorCursos {
    
    static Scanner sc = new Scanner(System.in);
  
    
    public static void crearCurso(String nombreCurso) throws IOException{
        File curso = new File(Main.RUTA_DATOS + Main.SEPARATOR + nombreCurso);
        File alumno = new File(Main.RUTA_DATOS + Main.SEPARATOR + nombreCurso + Main.SEPARATOR + "alumnos.txt");
        
        if(!(curso.exists())){
                curso.mkdir();
        }
        if(!(alumno.exists())){
                alumno.createNewFile();
        }

    }
    
    
}
