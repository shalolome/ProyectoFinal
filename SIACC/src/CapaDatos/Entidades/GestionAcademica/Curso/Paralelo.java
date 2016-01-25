
package CapaDatos.Entidades.GestionAcademica.Curso;

public class Paralelo {
    private long codigo;
    private String nombre;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
}
