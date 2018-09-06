/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.ModelsIMC;
import views.ViewsIMC;
import controllers.ControllersIMC;

public class Main {
 private static ViewsIMC views;
    private static ModelsIMC models;
    private static ControllersIMC controllers;
public static void main(String[] args){
    views = new ViewsIMC();
    models = new ModelsIMC();
    controllers = new ControllersIMC(views,models);
    
}
}