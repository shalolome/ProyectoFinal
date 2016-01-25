
package CapaDatos.Entidades.GestionAdministrativa.Institucional;

public class AsignacionSecciones {
    private long codigo;
    private long codigoInstitucion;
    private long codigoSeccion;
    private String descripcion;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(long codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public long getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(long codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
