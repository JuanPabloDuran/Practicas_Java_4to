
package main;
import views.View;
import models.Models;
import controllers.Controllers;

public class Main {
    private static View views;
    private static Models models;
    private static Controllers controllers;
public static void main(String[] args){
    views = new View();
    models = new Models();
    controllers = new Controllers(views,models);
}
    
    
}
