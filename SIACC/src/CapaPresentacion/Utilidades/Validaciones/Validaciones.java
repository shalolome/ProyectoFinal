
package CapaPresentacion.Utilidades.Validaciones;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JTextField;

public class Validaciones {
    //Metodo para convertir letras a Mayusculas
    public void convertirMayusculas(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
        }
    }
    
    //Metodo para Validar Letras con Espacios y Convertir en Mayusculas
    public void validarLetras(KeyEvent evt) {
        char validarJField = evt.getKeyChar();
        if ((validarJField < 'a' || validarJField > 'z') && (validarJField < 'A' || validarJField > 'Z')
                && validarJField !='á' //Minúsculas             
                && validarJField !='é'            
                && validarJField !='í'            
                && validarJField !='ó'           
                && validarJField !='ú'   
                && validarJField !='Á' //Mayúsculas             
                && validarJField !='É'            
                && validarJField !='Í'            
                && validarJField !='Ó'           
                && validarJField !='Ú'
                && (validarJField != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
        
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
        }
    }
    
    //Metodo para Validar Letras con Espacios y Convertir en Mayusculas
    public void LetrasSimbolos(KeyEvent evt) {
        char validarJField = evt.getKeyChar();
        if ((validarJField < 'a' || validarJField > 'z') && (validarJField < 'A' || validarJField > 'Z')
                && validarJField !='á' //Minúsculas             
                && validarJField !='é'            
                && validarJField !='í'            
                && validarJField !='ó'           
                && validarJField !='ú'   
                && validarJField !='Á' //Mayúsculas             
                && validarJField !='É'            
                && validarJField !='Í'            
                && validarJField !='Ó'           
                && validarJField !='Ú'
                && validarJField !='/'
                && validarJField !='-'
                && validarJField !=','
                && validarJField !=';'
                && validarJField !=':'
                && (validarJField != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
        
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
        }
    }
    
    //Metodo para Validar Letras, Numeros, Espacios y Convertir en Mayusculas
    public void convMayNumEscap(KeyEvent evt) {
        char validarJField = evt.getKeyChar();
        if ((validarJField < 'a' || validarJField > 'z') && (validarJField < 'A' || validarJField > 'Z')
                && (validarJField != (char) KeyEvent.VK_SPACE) && (validarJField < '0' || validarJField > '9')) {
            evt.consume();
        }
        
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
        }
    }
    
    //Metodo para Validar Numeros Enteros
    public void numerosEnteros(KeyEvent evt) {                                       
        char validarJField = evt.getKeyChar();        
        if(validarJField < '0' || validarJField > '9') 
            evt.consume();        
    }
    
    //Metodo para Validar Numeros de Cedula
    public void numerosCedula(KeyEvent evt, JTextField texto) {                                       
        char validarJField = evt.getKeyChar();        
        if(validarJField < '0' || validarJField > '9') 
            evt.consume();
        if(texto.getText().length()==10)
            evt.consume();
    }
    
    //Metodo para Validar Numeros Decimales
    public void numerosDecimales(KeyEvent evt, JTextField txt_numero) { 
        char validarJField = evt.getKeyChar();
        if (((validarJField < '0') || (validarJField > '9')) && (validarJField != KeyEvent.VK_BACK_SPACE)
                && (validarJField != '.')) evt.consume();
                                    
        if ( validarJField == '.' && txt_numero.getText().contains("."))  evt.consume();                  
    }
    
    //Metodo para redondear cantidades decimales
    public BigDecimal Redondeo(double monto){
        BigDecimal decimales,redondeo;
        decimales=new BigDecimal(monto);
        redondeo=decimales.setScale(2, RoundingMode.HALF_UP);
        return redondeo;
    }
    
    //Metodo para Validar Letras con Espacios y Convertir en Mayusculas del Trabajador
    public void validarNombreTrabajador(KeyEvent evt, JTextField texto) {
        char validarJField = evt.getKeyChar();
        if ((validarJField < 'a' || validarJField > 'z') && (validarJField < 'A' || validarJField > 'Z')
                && validarJField !='á' //Minúsculas             
                && validarJField !='é'            
                && validarJField !='í'            
                && validarJField !='ó'           
                && validarJField !='ú'   
                && validarJField !='Á' //Mayúsculas             
                && validarJField !='É'            
                && validarJField !='Í'            
                && validarJField !='Ó'           
                && validarJField !='Ú'
                && (validarJField != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
        
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
        }
        
        if(texto.getText().length() == 29){
            evt.consume();
        }
    }
    
    //Metodo para Validar Numeros de Telefono y Celular
    public void numerosTelefonoCelular(KeyEvent evt, JTextField texto) {                                       
        char validarJField = evt.getKeyChar();        
        if(validarJField < '0' || validarJField > '9') 
            evt.consume();
        if(texto.getText().length() == 13)
            evt.consume();
    }
    
    //Metodo para Validar Sueldo de Trabajador
    public void longitudSueldo(KeyEvent evt, JTextField txt_numero) { 
        char validarJField = evt.getKeyChar();
        if (((validarJField < '0') || (validarJField > '9')) && (validarJField != KeyEvent.VK_BACK_SPACE)
                && (validarJField != '.')) evt.consume();
                                    
        if ( validarJField == '.' && txt_numero.getText().contains("."))  
            evt.consume();   
        if(txt_numero.getText().length()==18)
            evt.consume();
    }
    
     //Metodo para Validar Letras, Numeros, Espacios y Convertir en Mayusculas
    public void longitudContrato(KeyEvent evt, JTextField txtContrato) {
        char validarJField = evt.getKeyChar();
        if ((validarJField < 'a' || validarJField > 'z') && (validarJField < 'A' || validarJField > 'Z')
                && (validarJField != (char) KeyEvent.VK_SPACE) && (validarJField < '0' || validarJField > '9')) {
            evt.consume();
        }
        
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
        }
        if(txtContrato.getText().length()==12)
            evt.consume();
    }
}
