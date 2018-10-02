
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo
 */
public class ModelsBD {

  
    String Nombre;
    String EMail;
    String Path;
    String Text;
    private List datos = new ArrayList<>();
    int P;
    int longitud;

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    /*
    Este Metodo concatenará el nombre que se obtenga del jtf_Nombre y el email que obtenga del jtf_Mail, esto separado con una coma para posteriormente guardarlo en un archivo csv
    */
    public String Concatena(){
       String Concat = "";
        Concat = this.getNombre().concat(",");
        Concat = Concat.concat(this.getEMail());
        return Concat;
    }
     public void openfile(String path) {
        try {
            String Separator = ",";
            int x = 0;
            int y = 1;
            datos.clear();
            longitud = 0;
            String row;
            try (FileReader file = new FileReader(path)) {
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while ((row = bufferedReader.readLine()) != null) {
                    String[] txt = row.split(Separator);
                    datos.add(row);
                    longitud++;
                }
            }
        } catch (FileNotFoundException err) {
           JOptionPane.showMessageDialog(null, "Error Archivo no encontrado :" + err.getMessage());
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Error en entrada y salida :" + io.getMessage());
        }
    }
      public void writefile(String Path, String Text) {
        try {
            File file = new File(Path);
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(Text);
                printWriter.flush();
                printWriter.close();
            }
        } catch (IOException err) {
            JOptionPane.showMessageDialog(null, "Error en entrada y salida :" + err.getMessage());
        }
        
    }
      private void ObtenDatos(int P) {
        String row[];
        row = String.valueOf(datos.get(P)).split(",");
        Nombre = row[0];
        EMail = row[1];
    }
      public void PrimerRegistro(){
        P = 0;
        ObtenDatos(P);  
      }
      public void AnteriorRegistro(){
        P--;
        ObtenDatos(P);
      }
      public void SiguienteRegistro(){
        P++;
        ObtenDatos(P);
      }
      public void UltimoRegistro(){
        P = longitud -1;
        ObtenDatos(P);
      }
}
