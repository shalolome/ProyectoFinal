
package CapaDatos.Entidades.GestionAdministrativa.Institucional;

public class AsigCargos {
    private long codigo;
    private long codigoPersona;
    private long codigoCargos;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(long codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public long getCodigoCargos() {
        return codigoCargos;
    }

    public void setCodigoCargos(long codigoCargos) {
        this.codigoCargos = codigoCargos;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
