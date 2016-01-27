
package CapaDatos.Entidades.GestionCalificaciones;

public class Calificaciones {
    private long codigo;
    private long codigoMatricula;
    private long codigoDistributivo;
    private long codigoPeriodoAcedemico;
    private long codigoTipoNota;
    private float nota;
    private String totalNota;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(long codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public long getCodigoDistributivo() {
        return codigoDistributivo;
    }

    public void setCodigoDistributivo(long codigoDistributivo) {
        this.codigoDistributivo = codigoDistributivo;
    }

    public long getCodigoPeriodoAcedemico() {
        return codigoPeriodoAcedemico;
    }

    public void setCodigoPeriodoAcedemico(long codigoPeriodoAcedemico) {
        this.codigoPeriodoAcedemico = codigoPeriodoAcedemico;
    }

    public long getCodigoTipoNota() {
        return codigoTipoNota;
    }

    public void setCodigoTipoNota(long codigoTipoNota) {
        this.codigoTipoNota = codigoTipoNota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getTotalNota() {
        return totalNota;
    }

    public void setTotalNota(String totalNota) {
        this.totalNota = totalNota;
    }
}
