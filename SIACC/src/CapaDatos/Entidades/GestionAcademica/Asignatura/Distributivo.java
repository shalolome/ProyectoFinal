
package CapaDatos.Entidades.GestionAcademica.Asignatura;

public class Distributivo {
    private long codigo;
    private long codigoMallaCurricular;
    private long codigoGrado;
    private long asignacionCargo;
    private String descripcion;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoMallaCurricular() {
        return codigoMallaCurricular;
    }

    public void setCodigoMallaCurricular(long codigoMallaCurricular) {
        this.codigoMallaCurricular = codigoMallaCurricular;
    }

    public long getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(long codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

    public long getAsignacionCargo() {
        return asignacionCargo;
    }

    public void setAsignacionCargo(long asignacionCargo) {
        this.asignacionCargo = asignacionCargo;
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
