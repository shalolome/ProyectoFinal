
package CapaDatos.Entidades.GestionAdministrativa.Institucional;

import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;

public class Personal extends Persona{
    private long codigoPersonal;
    private long codigoProfesion;
    private long codigoParroquia;
    private String telefono;
    private String celular;
    private String correo;
    private char estadoPersonal;

    public long getCodigoPersonal() {
        return codigoPersonal;
    }

    public void setCodigoPersonal(long codigoPersonal) {
        this.codigoPersonal = codigoPersonal;
    }

    public long getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(long codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public char getEstadoPersonal() {
        return estadoPersonal;
    }

    public void setEstadoPersonal(char estadoPersonal) {
        this.estadoPersonal = estadoPersonal;
    }

    public long getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(long codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }
}
