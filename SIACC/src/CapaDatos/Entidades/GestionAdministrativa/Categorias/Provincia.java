
package CapaDatos.Entidades.GestionAdministrativa.Categorias;

public class Provincia extends Pais{
    private long codigoProvincia;
    private String nombreProvincia;
    private char estadoProvincia;

    public long getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(long codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public char getEstadoProvincia() {
        return estadoProvincia;
    }

    public void setEstadoProvincia(char estadoProvincia) {
        this.estadoProvincia = estadoProvincia;
    }
    
    @Override
    public String toString() {
        return nombreProvincia;
    }
}
