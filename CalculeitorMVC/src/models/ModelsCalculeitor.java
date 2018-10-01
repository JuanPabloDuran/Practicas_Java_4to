
package models;


public class ModelsCalculeitor {
    private float Numero1;
    private float Numero2;
    private float Resultado;

    public float getNumero1() {
        return Numero1;
    }

    public void setNumero1(float Numero1) {
        this.Numero1 = Numero1;
    }

    public float getNumero2() {
        return Numero2;
    }

    public void setNumero2(float Numero2) {
        this.Numero2 = Numero2;
    }

    public float getResultado() {
        return Resultado;
    }

    public void setResultado(float Resultado) {
        this.Resultado = Resultado;
    }
    public float OperacionS(){
    this.Resultado = this.Numero1 + this.Numero2;
    return this.Resultado;
    }  
    public float OperacionR(){
    this.Resultado = this.Numero1 - this.Numero2;
    return this.Resultado;
    }  
    public float OperacionM(){
    this.Resultado = this.Numero1 * this.Numero2;
    return this.Resultado;
    }  
    public float OperacionD(){
    this.Resultado = this.Numero1 / this.Numero2;
    return this.Resultado;
    }  
    public float OperacionMod(){
    this.Resultado = this.Numero1 % this.Numero2;
    return this.Resultado;
    }
   
}
