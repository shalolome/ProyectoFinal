
package CapaDatos.Entidades.GestionCalificaciones;

public class DetalleActaParcial {
    private long codigo;
    private long codigoActaParcial;
    private long codigoMatricula;
    private float notaTai;
    private float notaIac;
    private float notaAgc;
    private float notaLoe;
    private float evualuacion;
    private float promedio;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoActaParcial() {
        return codigoActaParcial;
    }

    public void setCodigoActaParcial(long codigoActaParcial) {
        this.codigoActaParcial = codigoActaParcial;
    }

    public long getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(long codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public float getNotaTai() {
        return notaTai;
    }

    public void setNotaTai(float notaTai) {
        this.notaTai = notaTai;
    }

    public float getNotaIac() {
        return notaIac;
    }

    public void setNotaIac(float notaIac) {
        this.notaIac = notaIac;
    }

    public float getNotaAgc() {
        return notaAgc;
    }

    public void setNotaAgc(float notaAgc) {
        this.notaAgc = notaAgc;
    }

    public float getNotaLoe() {
        return notaLoe;
    }

    public void setNotaLoe(float notaLoe) {
        this.notaLoe = notaLoe;
    }

    public float getEvualuacion() {
        return evualuacion;
    }

    public void setEvualuacion(float evualuacion) {
        this.evualuacion = evualuacion;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
