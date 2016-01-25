
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.EstadoCivil;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaEstadoCivil {
    //Metodo para Obtener Arralist de Estado Civil
    public ArrayList<EstadoCivil> listarEstadoCivil() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_estadocivil WHERE estado_eciv LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Estados Civiles en ArrayList");
        }
    }
    
    ////Buscar Estados Civiles por Codigo
    public EstadoCivil buscarEstadoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_estadocivil WHERE "
                    + "codigo_eciv='"+codigo+"' AND estado_eciv LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Estados Civiles por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private EstadoCivil Crear(ResultSet rs) {
        EstadoCivil obj;
        try {
            obj = new EstadoCivil();
            obj.setCodigo(rs.getLong("codigo_eciv"));
            obj.setNombre(rs.getString("nombre_eciv"));
            obj.setEstado(rs.getString("estado_eciv").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
