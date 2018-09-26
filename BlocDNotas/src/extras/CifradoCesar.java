
package extras;


public class CifradoCesar {
    private String Mayus;
    private String Minus;

    public CifradoCesar(String Mayus, String Minus) {
        this.Mayus = Mayus;
        this.Minus = Minus;
    }
    public String cifrar(String message, int Cifrado){
        String cifrado = "";
        for (int i = 0; i < message.length(); i ++){
            if(this.Mayus.indexOf(message.charAt(i)) != -1 || this.Minus.indexOf(message.charAt(i)) != -1){
                cifrado += (this.Mayus.indexOf(message.charAt(i)) != -1) ? this.Mayus.charAt((this.Mayus.indexOf(message.charAt(i)) + Cifrado)%this.Mayus.length()): this.Minus.charAt((this.Minus.indexOf(message.charAt(i)) + Cifrado)%this.Minus.length());
            }else{
                cifrado += message.charAt(i);
            }
        }
        return cifrado;
    }
    public String descifrar(String message, int Cifrado){
        String cifrado = "";
        for (int i = 0; i < message.length(); i ++){
            if(this.Mayus.indexOf(message.charAt(i)) != -1 || this.Minus.indexOf(message.charAt(i)) != -1){
                if(this.Mayus.indexOf(message.charAt(i)) != -1){
                    if(this.Mayus.indexOf(message.charAt(i)) - Cifrado < 0 ){
                        cifrado += this.Mayus.charAt((this.Mayus.length())+((this.Mayus.indexOf(message.charAt(i)))-Cifrado));
                     }else{
                        cifrado += this.Mayus.charAt((this.Mayus.indexOf(message.charAt(i)) - Cifrado) % (this.Mayus.length()));
                     }
                }else{
                    if (this.Minus.indexOf(message.charAt(i)) - Cifrado < 0){
                         cifrado += this.Minus.charAt((this.Minus.length())+((this.Minus.indexOf(message.charAt(i)))-Cifrado));
                     }else{
                        cifrado += this.Minus.charAt((this.Minus.indexOf(message.charAt(i)) - Cifrado) % (this.Minus.length()));
                     }
                }
            }else{
                cifrado += message.charAt(i);
            }
        }
        return cifrado;
    }
}
