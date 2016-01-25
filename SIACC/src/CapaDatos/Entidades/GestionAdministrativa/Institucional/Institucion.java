
package CapaDatos.Entidades.GestionAdministrativa.Institucional;

public class Institucion {
    private long codigo;
    private long codigoRepresentante;
    private long codigoParroquia;
    private String nombre;
    private String codigoDistrito;
    private String telefono1;
    private String telefono2;
    private String celular1;
    private String celular2;
    private String fax;
    private String correo;
    private String direccion;
    private char estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoRepresentante() {
        return codigoRepresentante;
    }

    public void setCodigoRepresentante(long codigoRepresentante) {
        this.codigoRepresentante = codigoRepresentante;
    }

    public long getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(long codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
