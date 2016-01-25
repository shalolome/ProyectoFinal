
package CapaDatos.Entidades.GestionEstudiantil;

import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;

public class Estudiantes extends Persona{
    private long codigoEstudiante;
    private String codigoMagisterio;
    private String fechaNacimiento;
    private long codigoParroquia;
    private char estadoEstudiante;

    public long getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(long codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoMagisterio() {
        return codigoMagisterio;
    }

    public void setCodigoMagisterio(String codigoMagisterio) {
        this.codigoMagisterio = codigoMagisterio;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(long codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }

    public char getEstadoEstudiante() {
        return estadoEstudiante;
    }

    public void setEstadoEstudiante(char estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }
}
