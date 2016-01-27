
package CapaDatos.Entidades.GestionCalificaciones;

public class DetalleActaQuimestre {
    private long codigo;
    private long codigoActaQuimestre;
    private long codigoMatricula;
    private float parcial1;
    private float parcial2;
    private float parcial3;
    private float promedio;
    private float examen;
    private float promedioFinal;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoActaQuimestre() {
        return codigoActaQuimestre;
    }

    public void setCodigoActaQuimestre(long codigoActaQuimestre) {
        this.codigoActaQuimestre = codigoActaQuimestre;
    }

    public long getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(long codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public float getParcial1() {
        return parcial1;
    }

    public void setParcial1(float parcial1) {
        this.parcial1 = parcial1;
    }

    public float getParcial2() {
        return parcial2;
    }

    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
    }

    public float getParcial3() {
        return parcial3;
    }

    public void setParcial3(float parcial3) {
        this.parcial3 = parcial3;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public float getExamen() {
        return examen;
    }

    public void setExamen(float examen) {
        this.examen = examen;
    }

    public float getPromedioFinal() {
        return promedioFinal;
    }

    public void setPromedioFinal(float promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
