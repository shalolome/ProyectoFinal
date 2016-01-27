
package CapaDatos.Entidades.GestionCalificaciones;

public class Acta {
    private long codigo;
    private long codigoPeriodo;
    private long codigoDistributivo;
    private String fechaRegistro;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(long codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public long getCodigoDistributivo() {
        return codigoDistributivo;
    }

    public void setCodigoDistributivo(long codigoDistributivo) {
        this.codigoDistributivo = codigoDistributivo;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
