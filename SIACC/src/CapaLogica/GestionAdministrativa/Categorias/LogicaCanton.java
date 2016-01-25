
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Canton;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaCanton {
    //Metodo para Obtener Arralist de Canton
    public ArrayList<Canton> listarCantones(long codigoProvincia) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_canton WHERE codigo_prov='"+codigoProvincia+"' "
                    + "AND estado_cant LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Canton en ArrayList");
        }
    }
    
    ////Buscar Canton por Codigo
    public Canton buscarCantonPorCod(long codigo, long codigoProvincia) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_canton WHERE "
                    + "codigo_cant='"+codigo+"' AND estado_cant LIKE 'A' AND codigo_prov='"+codigoProvincia+"'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Cantones por Codigo");
        }
    }
    
    ////Buscar Canton por Codigo
    public Canton buscarCanton(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_canton WHERE "
                    + "codigo_cant='"+codigo+"' AND estado_cant LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Cantones por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Canton Crear(ResultSet rs) {
        Canton obj;
        try {
            obj = new Canton();
            obj.setCodigoCanton(rs.getLong("codigo_cant"));
            obj.setCodigoProvincia(rs.getLong("codigo_prov"));
            obj.setNombreCanton(rs.getString("nombre_cant"));
            obj.setEstadoCanton(rs.getString("estado_cant").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
