
package CapaDatos.Entidades.GestionCalificaciones;

public class PeriodoAcademicos {
    private long codigo;
    private long codioPadre;
    private String nombre;
    private String descripcion;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodioPadre() {
        return codioPadre;
    }

    public void setCodioPadre(long codioPadre) {
        this.codioPadre = codioPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
