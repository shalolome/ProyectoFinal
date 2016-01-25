
package CapaDatos.Entidades.GestionAcademica.Curso;

public class Grado {
    private long codigo;
    private long codigoNivel;
    private long codigoParalelo;
    private long codigoSeccion;
    private long codigoAnioLectivo;
    private String nombre;
    private String descripcion;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoNivel() {
        return codigoNivel;
    }

    public void setCodigoNivel(long codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    public long getCodigoParalelo() {
        return codigoParalelo;
    }

    public void setCodigoParalelo(long codigoParalelo) {
        this.codigoParalelo = codigoParalelo;
    }

    public long getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(long codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public long getCodigoAnioLectivo() {
        return codigoAnioLectivo;
    }

    public void setCodigoAnioLectivo(long codigoAnioLectivo) {
        this.codigoAnioLectivo = codigoAnioLectivo;
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
