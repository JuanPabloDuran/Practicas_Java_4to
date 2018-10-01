
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Models;
import views.View;
public class Controllers implements ActionListener {
    private final Models models;
    private final View views;
    
    public Controllers(View views, Models models){
        this.views = views;
        this.models = models;
        views.jb_Hello.addActionListener(this);
        views.jb_Bye.addActionListener(this);
        views.jb_Who.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent P) {
       if(P.getSource()==views.jb_Hello)
           ActionPerfomed();
       else if(P.getSource()==views.jb_Bye)
           ActionPerfomedBye();
       else if(P.getSource()==views.jb_Who)
           ActionPerfomedWho();
    }

    private void ActionPerfomed() {
        models.setMessage("Hello im MVC");
        views.jl_Message.setText(models.getMessage());
    }
     private void ActionPerfomedBye() {
        models.setMessage("Nice to meet you, come back again!");
        views.jl_Message.setText(models.getMessage());
    }
      private void ActionPerfomedWho() {
        models.setMessage("Im a Model of programation in the all Lenguages arround the world!");
        views.jl_Message.setText(models.getMessage());
    }
    public final void initView(){
        views.setTitle("Hello im MVC");
        views.setLocationRelativeTo(null);
    views.jl_Message.setText(models.getMessage());
        views.setVisible(true);
    }
    
}
