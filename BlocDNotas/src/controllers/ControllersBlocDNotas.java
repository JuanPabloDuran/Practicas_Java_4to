package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import views.ViewsBlocDNotas;
import models.ModelsBlocDNotas;
import extras.CifradoCesar;
import java.awt.Color;

public class ControllersBlocDNotas implements ActionListener {
    String Mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String Minus = "abcdefghijklmnopqrstuvwxyz";
    private final ModelsBlocDNotas models;
    private final ViewsBlocDNotas views;
    CifradoCesar cifradocesar = new CifradoCesar(Mayus , Minus);

    public ControllersBlocDNotas(ModelsBlocDNotas models, ViewsBlocDNotas views) {
        this.models = models;
        this.views = views;

        views.jmi_Leer.addActionListener(this);
        views.jmi_Guardar.addActionListener(this);
        views.jmi_cifrar.addActionListener(this);
        views.jmi_descifrar.addActionListener(this);
        initview();
    }

    @Override
    public void actionPerformed(ActionEvent P) {
        if (P.getSource() == views.jmi_Leer) {
            SeleccionaPath();
            ActionLeer();
        } else if (P.getSource() == views.jmi_Guardar) {
            SeleccionaPath();
            ActionGuardar();
        } else if (P.getSource() == views.jmi_cifrar){
            cifrar();
        } else if (P.getSource() == views.jmi_descifrar){
            descifrar();
        }
    }

    public void ActionLeer() {
        
        models.readfile(models.getPath());
        views.jta_Archivo.setText(models.getMessage());

    }

    public void ActionGuardar() {
        
        models.setMessage(views.jta_Archivo.getText());
        models.writefile(models.getPath(), models.getMessage());
    }
    
    private void SeleccionaPath() {
        JFileChooser file = new JFileChooser();
        file.showSaveDialog(null);
        models.setPath(""+file.getSelectedFile());
    }
    private void cifrar(){
        String Cifrado = cifradocesar.cifrar(views.jta_Archivo.getText(), 11);
        views.jta_Archivo.setText(Cifrado);
        
    }
    private void descifrar(){
        String Cifrado = cifradocesar.descifrar(views.jta_Archivo.getText(), 11);
        views.jta_Archivo.setText(Cifrado);
    }


    public void initview() {
        views.setLocationRelativeTo(null);
        views.setVisible(true);
        views.setTitle("Bloc de Notas");
        views.setBackground(Color.blue);
    }
}
