
package CapaDatos.Entidades.GestionAdministrativa.Categorias;

public class Parroquia extends Canton {
    private long codigoParroquia;
    private String nombreParroquia;
    private char estadoParroquia;

    public long getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(long codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }

    public String getNombreParroquia() {
        return nombreParroquia;
    }

    public void setNombreParroquia(String nombreParroquia) {
        this.nombreParroquia = nombreParroquia;
    }

    public char getEstadoParroquia() {
        return estadoParroquia;
    }

    public void setEstadoParroquia(char estadoParroquia) {
        this.estadoParroquia = estadoParroquia;
    }
    
    @Override
    public String toString() {
        return nombreParroquia;
    }
}
