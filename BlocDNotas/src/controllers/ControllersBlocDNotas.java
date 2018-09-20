package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import views.ViewsBlocDNotas;
import models.ModelsBlocDNotas;

public class ControllersBlocDNotas implements ActionListener {

    private final ModelsBlocDNotas models;
    private final ViewsBlocDNotas views;

    public ControllersBlocDNotas(ModelsBlocDNotas models, ViewsBlocDNotas views) {
        this.models = models;
        this.views = views;

        views.jmi_Leer.addActionListener(this);
        views.jmi_Guardar.addActionListener(this);
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
        }
    }

    public void ActionLeer() {
        models.setPath("c:\\archivos\\texto1.txt");
        models.readfile(models.getPath());
        views.jta_Archivo.setText(models.getMessage());

    }

    public void ActionGuardar() {
        models.setPath("c:\\archivos\\texto1.txt");
        models.setMessage(views.jta_Archivo.getText());
        models.writefile(models.getPath(), models.getMessage());
    }
    
    private void SeleccionaPath() {
        JFileChooser file=new JFileChooser();
        models.setPath(""+file.getSelectedFile());
    }


    public void initview() {
        views.setLocationRelativeTo(null);
        views.setVisible(true);
        views.setTitle("Bloc de Notas");
    }
}
