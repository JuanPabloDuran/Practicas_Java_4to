
package main;

import models.ModelsBlocDNotas;
import views.ViewsBlocDNotas;
import controllers.ControllersBlocDNotas;

public class Main {
    private static ModelsBlocDNotas models;
    private static ViewsBlocDNotas views;
    private static ControllersBlocDNotas controllers;
    
    
    public static void main(String[] args) {
        models = new ModelsBlocDNotas();
        views = new ViewsBlocDNotas();
        controllers = new ControllersBlocDNotas(models, views);
    }
    
}
