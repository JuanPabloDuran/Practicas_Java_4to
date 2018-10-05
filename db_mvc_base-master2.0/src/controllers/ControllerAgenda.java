/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Juan Pablo
 */
public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jb_Nuevo) {
                Nuevo();
            } else if (e.getSource() == viewAgenda.jb_Insertar) {
                Insertar();
            } else if (e.getSource() == viewAgenda.jb_Modificacion) {
                Modificar();
            } else if (e.getSource() == viewAgenda.jb_Eliminar) {
                Eliminar();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jb_Eliminar.addActionListener(actionListener);
        viewAgenda.jb_Nuevo.addActionListener(actionListener);
        viewAgenda.jb_Insertar.addActionListener(actionListener);
        viewAgenda.jb_Modificacion.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        modelAgenda.moverPrimerRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
        modelAgenda.moverAnteriorRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
       modelAgenda.moverUltimoRegistro();
       viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
       viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
        modelAgenda.moverSiguienteRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    /**
     * Método para Limpiar cajas de texto
     */
    private void Nuevo(){
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_email.setText("");
    }
    /**
     * Método para Insertar un nuevo registro en la base de datos
     */
    private void Insertar(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText());
        modelAgenda.InsertarRegistro();
        initDB();
    }
    /**
     * Método para Modificar el email del registro seleccionado
     */
    private void Modificar(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText());
        modelAgenda.ModificarRegistro();
        initDB();  
    }
    /**
     * Método para eliminar el registro seleccionado de la base de datos
     * El JOption Pane mostrara un mensaje de confirmación de si o no para que el usuario decida si eliminar el registro o no
     * Los valores que regresa el JOprionPane son si = 0 no =1 
     */
    private void Eliminar(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText());
        int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(resp == 0){
         modelAgenda.EliminaRegistro();
         initDB();   
        }else{
           initDB();
           JOptionPane.showMessageDialog(null, "Uff por poco");
        }
      
    }
}
