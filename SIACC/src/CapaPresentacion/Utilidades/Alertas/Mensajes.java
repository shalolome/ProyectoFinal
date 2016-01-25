
package CapaPresentacion.Utilidades.Alertas;

import javax.swing.JOptionPane;

public class Mensajes {
    //Metodo para Generar mensajes de Error en el Formulario
    public void MensajeError(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    //Metodo para Generar mensajes de Error en el Formulario
    public void MensajeInformacion(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
