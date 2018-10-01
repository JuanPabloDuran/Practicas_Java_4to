/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.ModelsBD;
import views.ViewsBD;
import controllers.ControllersBD;
/**
 *
 * @author Juan Pablo
 */
public class Main {
    public static ModelsBD models;
    public static ViewsBD views;
    public static ControllersBD controllers;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       models = new ModelsBD();
       views = new ViewsBD();
       controllers = new ControllersBD(models , views);
    }
    
}
