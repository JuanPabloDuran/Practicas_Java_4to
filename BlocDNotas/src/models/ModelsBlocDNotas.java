/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo
 */
public class ModelsBlocDNotas {

    String message;
    String path;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Éste método sirve para leer el archivo que indique la variable path e
     * imprime lo que existe dentro del archivo
     *
     * @param path ruta que recibe para abrir el archivo de texto
     */
    public void readfile(String path) {
        try {
            String row;
            String txt = "";
            try (FileReader file = new FileReader(path)) {
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while ((row = bufferedReader.readLine()) != null) {
                    txt=txt+row+"\n";
                    System.out.println(row);
                }
                this.setMessage(txt);
                bufferedReader.close();
            }
        } catch (FileNotFoundException err) {
           JOptionPane.showMessageDialog(null, "Error Archivo no encontrado :" + err.getMessage());
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Error en entrada y salida :" + io.getMessage());
        }
    }

    /**
     * Éste método sirve para escribir en el archivo que indique la variable
     * path y guarda lo que se ecribe en el textarea por medio de la variable
     * message True = Guarda el texto nuevo junto con el anterior 
     * False = Sobreescribe el texto anterior con el nuevo
     * @param path
     * @param message
     */
    public void writefile(String path, String message) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(message);
                printWriter.close();
            }
        } catch (IOException err) {
            JOptionPane.showMessageDialog(null, "Error en entrada y salida :" + err.getMessage());
        }

    }
}
