/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelsBD;
import views.ViewsBD;
import javax.swing.JFileChooser;
/**
 *
 * @author Juan Pablo
 */
public class ControllersBD implements ActionListener{
    private final ModelsBD models;
    private final ViewsBD views;

    public ControllersBD(ModelsBD models, ViewsBD views) {
        this.models = models;
        this.views = views;
        views.jb_Save.addActionListener(this);
        views.jmi_open.addActionListener(this);
        initview();
    }

    @Override
    public void actionPerformed(ActionEvent P) {
        if(P.getSource() == views.jb_Save){
         SeleccionaPathS();
         Guardar();
        }else if(P.getSource() == views.jmi_open){
         SeleccionaPathL();
         Leer();
        }
    }
    public void Guardar(){
       models.setNombre(views.jtf_Nombre.getText());
       models.setEMail(views.jtf_Mail.getText());
       models.Concatena();
       models.setText(models.Concatena());
       models.writefile(models.getPath(), models.getText());
       System.out.println(models.Concatena());
    }
    public void Leer(){
       models.openfile(models.getPath());
       views.jtf_Nombre.setText(models.getNombre());
       views.jtf_Mail.setText(models.getEMail());
    }
    
    private void SeleccionaPathS() {
        JFileChooser file = new JFileChooser();
        file.showSaveDialog(null);
        models.setPath(""+file.getSelectedFile());
    }
    private void SeleccionaPathL() {
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        models.setPath(""+file.getSelectedFile());
    }
    public void initview(){
        views.setLocationRelativeTo(null);
        views.setTitle("Bata Dase");
        views.setVisible(true);
    }
}
