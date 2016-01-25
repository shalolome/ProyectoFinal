
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;
import java.sql.ResultSet;

public class LogicaPersona {
    //Metodo para Insertar Persona
    public long InsertGetId(Persona obj) {
        try {
            Conexion conexionBD = new Conexion();
            return conexionBD.InsertGetID("insert into siacc_persona "
                    + "(cedula_pers, pnombre_pers, snombre_pers, apaterno_pers, amaterno_pers, sexo_pers, "
                    + " direccion_pers, estado_pers) "
                    + "values('" + obj.getCedula() + "',"
                    + "'" + obj.getPrimerNombre()+ "',"
                    + "'" + obj.getSegundoNombre() + "',"
                    + "'" + obj.getApellidoPaterno()+ "',"
                    + "'" + obj.getApellidoMaterno()+ "',"
                    + "'" + obj.getCodigoGenero()+ "',"
                    + "'" + obj.getDireccion()+ "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Persona y Capturar ID");
        }
    }
    
    ///Actualizar Persona
    public void Actualizar(Persona obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_persona "
                    + "set cedula_pers='" + obj.getCedula()+ "', "
                    + "pnombre_pers='" + obj.getPrimerNombre()+ "' , "
                    + "snombre_pers='" + obj.getSegundoNombre()+ "' , "
                    + "apaterno_pers='" + obj.getApellidoPaterno()+ "' , "
                    + "amaterno_pers='" + obj.getApellidoMaterno()+ "' , "
                    + "sexo_pers='" + obj.getCodigoGenero()+ "' , "
                    + "direccion_pers='" + obj.getDireccion()+ "' "
                    + "where codigo_pers='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Persona");
        }
    }
    
    ////Buscar Persona por Codigo
    public Persona buscarPersonaPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_persona WHERE "
                    + "codigo_pers='"+codigo+"' AND estado_pers LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Persona por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Persona Crear(ResultSet rs) {
        Persona obj;
        try {
            obj = new Persona();
            obj.setCodigo(rs.getLong("codigo_pers"));
            obj.setCedula(rs.getString("cedula_pers"));
            obj.setPrimerNombre(rs.getString("pnombre_pers"));
            obj.setSegundoNombre(rs.getString("snombre_pers"));
            obj.setApellidoPaterno(rs.getString("apaterno_pers"));
            obj.setApellidoMaterno(rs.getString("amaterno_pers"));
            obj.setCodigoGenero(rs.getLong("sexo_pers"));
            obj.setDireccion(rs.getString("direccion_pers"));
            obj.setEstado(rs.getString("estado_pers").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
