
package CapaDatos.Entidades.GestionEstudiantil;

import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;

public class Representantes extends Persona{
    private long codigoRepresentante;
    private long codigoParroquia;
    private String email;
    private String telefono;
    private String celular;
    private char estadoRepresentante;

    public long getCodigoRepresentante() {
        return codigoRepresentante;
    }

    public void setCodigoRepresentante(long codigoRepresentante) {
        this.codigoRepresentante = codigoRepresentante;
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

    public char getEstadoRepresentante() {
        return estadoRepresentante;
    }

    public void setEstadoRepresentante(char estadoRepresentante) {
        this.estadoRepresentante = estadoRepresentante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(long codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }
}
