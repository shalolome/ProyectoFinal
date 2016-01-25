
package CapaPresentacion.Utilidades.Validaciones;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class MetodosBusquedas {
    //Metodo para Retornar indice del elemento JComboBox
    public int retornarIndice(JComboBox combo, String nombre){ 
        int indice=0;
             List<String> listaForm = new ArrayList<>();
             
            for (int i = 0; i < combo.getItemCount(); i++)              
                listaForm.add(combo.getItemAt(i).toString());
            
            for(int i= 0; i<listaForm.size(); i++){ 
                if(nombre.equals(listaForm.get(i).toString()))
                    indice = i;
            } 
        return indice;
    }
}
