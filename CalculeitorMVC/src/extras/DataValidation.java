
package extras;

import javax.swing.JOptionPane;


public class DataValidation {
   public int string2Int(String value){
    int Resultado = 0;
    try{
        Resultado = Integer.parseInt(value);
    }catch(NumberFormatException err){
       JOptionPane.showMessageDialog(null, "Error ingresa un valor numérico");
       Resultado = 0;
    }
    return Resultado;
}   
public float string2Float(String value){
    float Resultado = 0;
    try{
        Resultado = Float.parseFloat(value);
    }catch(NumberFormatException err){
        JOptionPane.showMessageDialog(null, "Error ingresa un valor numérico");
        Resultado = 0;
    }
    return Resultado;
}
public double string2Double(String value){
    double Resultado = 0;
    try{
        Resultado = Double.parseDouble(value);
    }catch(NumberFormatException err){
        JOptionPane.showConfirmDialog(null, "Error ingresa un valor numérico");
        Resultado = 0;
    }
    return Resultado;
}
 
}
