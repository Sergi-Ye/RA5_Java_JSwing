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
import model.GestorAlumnos;

public class ControladorAlumnos {

    public final static Scanner sc = new Scanner(System.in);
    static ArrayList<model.Alumno> alumnos;
    static String curso;
    
    public static void main(String args[]){
    }
    
    public static void anadir(){
        try{
            curso = VentanaCurso.curso;
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
        if(indexSeleccionado < 0){return;}
        try{
            curso = VentanaCurso.curso;
            alumnos = GestorAlumnos.leer(curso);
            alumnos.remove(indexSeleccionado);
            GestorAlumnos.eliminar(curso, alumnos);
        }catch(IOException e){
            System.err.println(e);
            sc.nextLine();
        }
    }
    
    public static void buscar(){
        try{
            curso = VentanaCurso.curso;
            String dni = JOptionPane.showInputDialog("Introduce el dni a buscar");
            
            if(dni.isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo vacio");
                return;
            }
            alumnos = GestorAlumnos.leer(curso);
            for(model.Alumno alumno: alumnos){
                String[] datos = alumno.toString().split(";");
                if(datos[3].equals(dni)){
                    JOptionPane.showMessageDialog(
                            null, 
                            "Nombre: " + datos[0] + 
                            "\nApellido: " + datos[1] + 
                            "\nEdad: " + datos[2] + 
                            "\nDNI: " + datos[3]
                    );
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se ha encontrado un alumno con este DNI");
            
        }catch(IOException e){
            System.err.println(e);
            sc.nextLine();
        }
    }
    
    public static void mostrar(int indexSeleccionado){
        if(indexSeleccionado < 0){return;}
        try{
            curso = VentanaCurso.curso;
            alumnos = GestorAlumnos.leer(curso);
            
            String[] alumno = alumnos.get(indexSeleccionado).toString().split(";");
            JOptionPane.showMessageDialog(
                    null, 
                    "Nombre: " + alumno[0] + 
                    "\nApellido: " + alumno[1] + 
                    "\nEdad: " + alumno[2] + 
                    "\nDNI: " + alumno[3]
            );
        }catch(IOException e){
            System.err.println(e);
            sc.nextLine();
        }
    }
    
    public static void editar(int indexSeleccionado){
        if(indexSeleccionado < 0){return;}
        try{
            curso = VentanaCurso.curso;
            alumnos = GestorAlumnos.leer(curso);

            model.Alumno alumno = alumnos.get(indexSeleccionado);

            String nombreNuevo = JOptionPane.showInputDialog("Nuevo nombre:", alumno.getNombre());
            if(nombreNuevo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo vacio");
                return;
            }
            String apellidoNuevo = JOptionPane.showInputDialog("Nuevo apellido:", alumno.getApellido());
            if(apellidoNuevo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo vacio");
                return;
            }
            String edadTexto = JOptionPane.showInputDialog("Nueva edad:", alumno.getEdad());
            if(edadTexto.isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo vacia");
                return;
            }
            
            int edadNueva;
            try{
                edadNueva = Integer.parseInt(edadTexto);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un numero");
                return;
            }
            
            String dniNuevo = JOptionPane.showInputDialog("Nuevo DNI:", alumno.getDni());
            if(dniNuevo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo vacio");
                return;
            }

            for(int i = 0; i < alumnos.size(); i++){
                if(i != indexSeleccionado && alumnos.get(i).getDni().equals(dniNuevo)){
                    JOptionPane.showMessageDialog(null, "Ya existe este dni");
                    return;
                }
            }

            alumno.setNombre(nombreNuevo);
            alumno.setApellido(apellidoNuevo);
            alumno.setEdad(edadNueva);
            alumno.setDni(dniNuevo);

            GestorAlumnos.eliminar(curso, alumnos);

            JOptionPane.showMessageDialog(null, "Alumno editado correctamente");

        }catch(IOException e){
            System.err.println(e);
            sc.nextLine();
        }
    }
    
}

    

