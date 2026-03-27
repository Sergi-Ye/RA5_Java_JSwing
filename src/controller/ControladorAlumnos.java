/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.VentanaCurso;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import main.Main;
import model.GestorAlumnos;

public class ControladorAlumnos {

    public final static Scanner sc = new Scanner(System.in);
    static ArrayList<model.Alumno> alumnos;
    static String curso = VentanaCurso.curso;
    
    public static void main(String args[]){
        System.out.println("si");

    }
    
    public static void anadir(){
        try{
            String nombre = VentanaCurso.nombre;
            String apellido = VentanaCurso.apellido;
            int edad = VentanaCurso.edad;
            String dni = VentanaCurso.dni;
            
            model.Alumno alumno = new model.Alumno(nombre, apellido, edad, dni);
            alumnos = GestorAlumnos.leer(curso);
            
            for(model.Alumno al: alumnos){
                if(al.getDni().equals(dni)){
                    JOptionPane.showMessageDialog(null, "Ya existe este dni");
                    return;
                } 
            }
            GestorAlumnos.añadir(curso, alumno);
            
        }catch(IOException e){
            System.err.println(e);
            sc.nextLine();
        }
    }
    
    public static void eliminar(int indexSeleccionado){
        try{
            alumnos = GestorAlumnos.leer(curso);
            alumnos.remove(indexSeleccionado);
            GestorAlumnos.eliminar(curso, alumnos);
        }catch(IOException e){
            System.err.println(e);
            sc.nextLine();
        }
    }

/*    public static void agregarAlumno() throws IOException{
        
        FileWriter fw = new FileWriter(registro, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        try {
            System.out.println("Introduzca el nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca el apellido:");
            String apellido = sc.nextLine();
            System.out.println("Introduzca la edad:");
            int edad = sc.nextInt(); 
            sc.nextLine();
            System.out.println("Introduzca el curso:");
            String curso = sc.nextLine();
            System.out.println("Introduzca el dni:");
            String dni = sc.nextLine();
        
            Alumno alumno = new Alumno(nombre, apellido, edad, curso, dni);
        
            bw.write(nombre + ", " + apellido + ", " + edad + ", " + curso + ", " + dni);
            bw.write(salto);
            bw.flush();
            bw.close();
            
        }catch(Exception e) {
            System.err.println(e + "\n");
            sc.nextLine(); 
        }

}
    public static void mostrarAlumnos() throws IOException{
        FileReader fr = new FileReader(registro);
        BufferedReader br = new BufferedReader(fr);
        
        try{
            String linea;
            
            while((linea = br.readLine())!= null){
                System.out.println(linea);
            }
            br.close();
        }
        catch(IOException e) {
            System.err.println(e + "\n");
            sc.nextLine();
        }
    }
    
   public static void eliminarAlumno() {
    try {
        String linea;
        String temporal = "";
        boolean encontrado = false;
        
        System.out.println("Lista de alumnos:");
        BufferedReader br = new BufferedReader(new FileReader(registro));
        while((linea = br.readLine())!= null){
                System.out.println(linea);
            }
        br.close();

        System.out.println("Escriba el DNI del alumno a eliminar:");
        String dni = sc.nextLine();

        br = new BufferedReader(new FileReader(registro));
        while ((linea = br.readLine()) != null) {
            if (!linea.contains(dni)) {
                temporal += linea + Main.SALTO;
            } else {
                encontrado = true;
            }
        }
        br.close();
        
        if (encontrado) {
            BufferedWriter bw = new BufferedWriter (new FileWriter(registro));
            bw.write(temporal);
            bw.flush();
            bw.close();
            System.out.println("Alumno eliminado correctamente");
        } else {
            System.out.println("No se ha econtrado este DNI");
        }

    }catch(IOException e){
        System.err.println(e + "\n");
        sc.nextLine();
    }
}
   
    public static void buscarDNI(){
        try{     
            String linea;
            boolean encontrado = false;
            System.out.println("Escriba el DNI del alumno::");
            String dni = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(registro));
            while((linea = br.readLine())!= null){
                    if(linea.contains(dni)){
                        System.out.println(linea);
                        encontrado = true;
                    }
                }
            br.close();
            
            if(!encontrado){
                System.out.println("No se ha encontrado este DNI");
            }
        }catch(IOException e){
            System.err.println(e + "\n");
            sc.nextLine();
        }
    }
*/
    
}

    

