
package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import java.sql.ResultSet;

public class LogicaInstitucion {
    
    ///Actualizar Institución
    public void Actualizar(Institucion obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_institucion "
                    + "set codigo_acar='" + obj.getCodigoRepresentante()+ "', "
                    + "codigo_parr='" + obj.getCodigoParroquia()+ "' ,"
                    + "nombre_inst='" + obj.getNombre()+ "' ,"
                    + "coddistrito_inst='" + obj.getCodigoDistrito()+ "' ,"
                    + "telefono1_inst='" + obj.getTelefono1()+ "' ,"
                    + "telefono2_inst='" + obj.getTelefono2()+ "' ,"
                    + "celular1_inst='" + obj.getCelular1()+ "' ,"
                    + "celular2_inst='" + obj.getCelular2()+ "' ,"
                    + "fax_inst='" + obj.getFax()+ "' ,"
                    + "correo_inst='" + obj.getCorreo()+ "' ,"
                    + "direccion_inst='" + obj.getDireccion()+ "' "
                    + "where codigo_inst='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Institución");
        }
    }
    
    ////Buscar Institución por Codigo
    public Institucion buscarInsititucionPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_institucion WHERE "
                    + "codigo_inst='" + codigo + "' AND estado_inst LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Institución por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Institucion Crear(ResultSet rs) {
        Institucion obj;
        try {
            obj = new Institucion();
            obj.setCodigo(rs.getLong("codigo_inst"));
            obj.setCodigoRepresentante(rs.getLong("codigo_acar"));
            obj.setCodigoParroquia(rs.getLong("codigo_parr"));
            obj.setNombre(rs.getString("nombre_inst"));
            obj.setCodigoDistrito(rs.getString("coddistrito_inst"));
            obj.setTelefono1(rs.getString("telefono1_inst"));
            obj.setTelefono2(rs.getString("telefono2_inst"));
            obj.setCelular1(rs.getString("celular1_inst"));
            obj.setCelular2(rs.getString("celular2_inst"));
            obj.setFax(rs.getString("fax_inst"));
            obj.setCorreo(rs.getString("correo_inst"));
            obj.setDireccion(rs.getString("direccion_inst"));
            obj.setEstado(rs.getString("estado_inst").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
