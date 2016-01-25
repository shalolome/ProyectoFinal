
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Parroquia;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaParroquia {
    //Metodo para Obtener Arralist de Parroquia
    public ArrayList<Parroquia> listarParroquias(long codigoCanton) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_parroquia WHERE codigo_cant='"+codigoCanton+"' "
                    + "AND estado_parr LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Parroquia en ArrayList");
        }
    }
    
    ////Buscar Parroquia por Codigo
    public Parroquia buscarParroquiaPorCod(long codigo, long codigoCanton) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_parroquia WHERE "
                    + "codigo_parr='"+codigo+"' AND estado_parr LIKE 'A' AND codigo_cant='"+codigoCanton+"'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Parroquias por Codigo");
        }
    }
    
    ////Buscar Parroquia por Codigo
    public Parroquia buscarParroquia(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_parroquia WHERE "
                    + "codigo_parr='"+codigo+"' AND estado_parr LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Parroquias por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Parroquia Crear(ResultSet rs) {
        Parroquia obj;
        try {
            obj = new Parroquia();
            obj.setCodigoParroquia(rs.getLong("codigo_parr"));
            obj.setCodigoCanton(rs.getLong("codigo_cant"));
            obj.setNombreParroquia(rs.getString("nombre_parr"));
            obj.setEstadoParroquia(rs.getString("estado_parr").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
