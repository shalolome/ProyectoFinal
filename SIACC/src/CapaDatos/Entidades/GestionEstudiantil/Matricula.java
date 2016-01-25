
package CapaDatos.Entidades.GestionEstudiantil;

public class Matricula {
    private long codigo;
    private long codigoEstudiante;
    private long codigoGrado;
    private long codigoRepresentante;
    private String fechaRegistro;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(long codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public long getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(long codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public long getCodigoRepresentante() {
        return codigoRepresentante;
    }

    public void setCodigoRepresentante(long codigoRepresentante) {
        this.codigoRepresentante = codigoRepresentante;
    }
}
