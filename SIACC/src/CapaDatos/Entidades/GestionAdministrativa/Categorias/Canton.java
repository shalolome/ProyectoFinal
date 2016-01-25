
package CapaDatos.Entidades.GestionAdministrativa.Categorias;

public class Canton extends Provincia{
    private long codigoCanton;
    private String nombreCanton;
    private char estadoCanton;

    public long getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(long codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public String getNombreCanton() {
        return nombreCanton;
    }

    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    public char getEstadoCanton() {
        return estadoCanton;
    }

    public void setEstadoCanton(char estadoCanton) {
        this.estadoCanton = estadoCanton;
    }
    
    @Override
    public String toString() {
        return nombreCanton;
    }
}
