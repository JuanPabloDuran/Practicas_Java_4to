
package main;

import models.ModelsCalculeitor;
import views.ViewsCalculeitor;
import controllers.ControllersCalculeitor;

public class Main {
    private static ModelsCalculeitor models;
    private static ViewsCalculeitor views;
    private static ControllersCalculeitor controllers;
public static void main(String[] args) {
    models = new ModelsCalculeitor();
    views = new ViewsCalculeitor();
    controllers = new ControllersCalculeitor(views,models);
    }
    
}
