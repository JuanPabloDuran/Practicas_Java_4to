
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelsIMC;
import views.ViewsIMC;
public class ControllersIMC implements ActionListener {
    private final ModelsIMC models;
    private final ViewsIMC views;

  
    public ControllersIMC(ViewsIMC views, ModelsIMC models){
        this.views = views;
        this.models = models;
        views.jb_Calcular.addActionListener(this);
        initView();
    }

    @Override
    public void actionPerformed(ActionEvent P) {
        if(P.getSource()==views.jb_Calcular)
           ActionPerformed();
    }
    private void ActionPerformed(){
      models.setAltura(Integer.parseInt(views.jtf_Altura.getText()));
      models.setPeso(Integer.parseInt(views.jtf_Peso.getText()));
      models.getIMC();
      double IMC = models.resultado();
      JOptionPane.showMessageDialog(null,"Tu IMC es:" + IMC);
      if ( IMC <= 16){
      views.jtf_IMC.setText(String.valueOf("Peso Bajo"));
    }
      else if ( IMC > 16 &&  IMC < 18){
          views.jtf_IMC.setText(String.valueOf("Peso Bajo-Moderado"));     
      }
      else if ( IMC > 18 && IMC < 20){
          views.jtf_IMC.setText(String.valueOf("Peso Moderado"));     
      }
      else if ( IMC > 20 && IMC < 23){
          views.jtf_IMC.setText(String.valueOf("Peso Alto-Moderado"));     
      }
      else if ( IMC > 23 && IMC < 24){
          views.jtf_IMC.setText(String.valueOf("Peso Alto"));     
      }
      else {
          views.jtf_IMC.setText(String.valueOf("No existe Valoracion"));
      }
    }
    private void initView(){
        views.setTitle("Calcula IMC con modelo MVC");
        views.setLocationRelativeTo(null);
        views.setVisible(true);
        JOptionPane.showMessageDialog(null,"Ingresa tu estatura en centimetros y tu peso redondeado por favor");
    }
}