
package CapaDatos.Entidades.GestionEstudiantil;

public class AsignacionRepresentante {
    private long codigoRepresentante;
    private long codigoEstudiante;
    private String referenciaLaboral;
    private String observacion;
    private char estado;

    public long getCodigoRepresentante() {
        return codigoRepresentante;
    }

    public void setCodigoRepresentante(long codigoRepresentante) {
        this.codigoRepresentante = codigoRepresentante;
    }

    public long getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(long codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getReferenciaLaboral() {
        return referenciaLaboral;
    }

    public void setReferenciaLaboral(String referenciaLaboral) {
        this.referenciaLaboral = referenciaLaboral;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
