
package models;

public class ModelsIMC {
    private double Peso;
    private double Altura;
    public double IMC;

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }
   public double resultado(){
       this.IMC = this.Peso / ((this.Altura/100) * (this.Altura/100));
        return this.IMC;         
    }
}
