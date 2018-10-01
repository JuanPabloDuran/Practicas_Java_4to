
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelsCalculeitor;
import views.ViewsCalculeitor;
import extras.DataValidation;

public class ControllersCalculeitor implements ActionListener{
    private final ModelsCalculeitor models;
    private final ViewsCalculeitor views;
    DataValidation datavalidation = new DataValidation();
    

    public ControllersCalculeitor(ViewsCalculeitor views, ModelsCalculeitor models) {
        this.views = views;
        this.models = models;
        views.jb_Div.addActionListener(this);
        views.jb_Sum.addActionListener(this);
        views.jb_Res.addActionListener(this);
        views.jb_Mult.addActionListener(this); 
        views.jb_Mod.addActionListener(this);
        initView();
    }

 
    @Override
    public void actionPerformed(ActionEvent P) {
        if(P.getSource() == views.jb_Sum)
        ActionCalcularSum();
        else if(P.getSource() == views.jb_Res)
        ActionCalcularRes();
        else if(P.getSource() == views.jb_Div)
        ActionCalcularDiv();
        else if(P.getSource() == views.jb_Mult)
        ActionCalcularMult();
        else if(P.getSource() == views.jb_Mod)
        ActionCalcularMod();
    }
    public void ActionCalcularSum(){
        models.setNumero1(datavalidation.string2Float(views.jtf_Numero1.getText()));
        models.setNumero2(datavalidation.string2Float(views.jtf_Numero2.getText()));
        models.getResultado();
        JOptionPane.showMessageDialog(null,"Tu resultado es: " + models.OperacionS());
    }
       public void ActionCalcularRes(){
        models.setNumero1(datavalidation.string2Float(views.jtf_Numero1.getText()));
        models.setNumero2(datavalidation.string2Float(views.jtf_Numero2.getText()));
        models.getResultado();
        JOptionPane.showMessageDialog(null,"tu resultado es: " + models.OperacionR());
       }
        public void ActionCalcularDiv(){
        models.setNumero1(datavalidation.string2Float(views.jtf_Numero1.getText()));
        models.setNumero2(datavalidation.string2Float(views.jtf_Numero2.getText()));
        models.getResultado();
        JOptionPane.showMessageDialog(null,"Tu resultado es: " + models.OperacionD());
        }
        public void ActionCalcularMult(){
        models.setNumero1(datavalidation.string2Float(views.jtf_Numero1.getText()));
        models.setNumero2(datavalidation.string2Float(views.jtf_Numero2.getText()));
        models.getResultado();
        JOptionPane.showMessageDialog(null,"tu resultado es: " + models.OperacionM());
        }
     
        public void ActionCalcularMod(){
        models.setNumero1(datavalidation.string2Float(views.jtf_Numero1.getText()));
        models.setNumero2(datavalidation.string2Float(views.jtf_Numero2.getText()));
        models.getResultado();
        JOptionPane.showMessageDialog(null,"tu resultado es: " + models.OperacionMod());
        }
    public void initView(){
        views.setLocationRelativeTo(null);
        views.setVisible(true);
        views.setTitle("Calculeitor");
    }
}
