/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import main.Main;
import model.GestorCursos;
import view.VentanaPrincipal;

public class ControladorCursos {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
    }
    
    public static void crear() {
        try{
            String nombreCurso = JOptionPane.showInputDialog("Introduce el nombre del curso");

            if (!nombreCurso.isEmpty()) {
                if(!VentanaPrincipal.modelo.contains(nombreCurso)){
                    VentanaPrincipal.modelo.addElement(nombreCurso);
                    GestorCursos.crearCurso(nombreCurso);
                    JOptionPane.showMessageDialog(null, nombreCurso + " se ha creado");
                }else{
                    JOptionPane.showMessageDialog(null, "Ya existe este curso");
                }
            }else{
               JOptionPane.showMessageDialog(null, "Campo Vacio"); 
            }
        }catch(Exception e) {
            System.err.println(e + "\n");
            sc.nextLine(); 
        }
    }
    
    public static void eliminar(String seleccionado){

        for(String curso: Main.CARPETA_DATOS.list()){
            if(curso.equals(seleccionado)){
                File carpeta = new File(Main.CARPETA_DATOS, curso);
                File archivo = new File(carpeta, "alumnos.txt");
                archivo.delete();
                carpeta.delete();
            }
        }
        System.out.println(seleccionado);
        VentanaPrincipal.modelo.removeElement(seleccionado);
        
        /*String nombreCurso = JOptionPane.showInputDialog("Introduce el nombre del curso");

        if (VentanaPrincipal.modelo.contains(nombreCurso)) {
            JOptionPane.showMessageDialog(null, nombreCurso + " Se ha eliminado");
            VentanaPrincipal.modelo.removeElement(nombreCurso);
        }else{
            JOptionPane.showMessageDialog(null, nombreCurso + " No existe");
        }*/
    }
    
    
    
 }
    

