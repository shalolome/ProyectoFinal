
package CapaDatos.Entidades.GestionAcademica.Asignatura;

public class Malla {
    private long codigo;
    private long codigoAsignatura;
    private long codigoCurso;
    private String nombre;
    private String descripcion;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(long codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
