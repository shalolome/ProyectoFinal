
package CapaLogica.GestionCalificaciones;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionCalificaciones.TipoNota;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaTipoNota {
    //Metodo para Obtener Arralist de Tipo de Nota
    public ArrayList<TipoNota> listarTipoNota() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_tiponota WHERE estado_tnot LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Tipo de Nota en ArrayList");
        }
    }
    
    ////Buscar Tipo de Nota por Codigo
    public TipoNota buscarPeriodoAcademicoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_tiponota WHERE "
                    + "codigo_tnot='"+codigo+"' AND estado_tnot LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Tipo de Nota por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private TipoNota Crear(ResultSet rs) {
        TipoNota obj;
        try {
            obj = new TipoNota();
            obj.setCodigo(rs.getLong("codigo_tnot"));
            obj.setDescripcion(rs.getString("descripcion_tnot"));
            obj.setEstado(rs.getString("estado_tnot").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
