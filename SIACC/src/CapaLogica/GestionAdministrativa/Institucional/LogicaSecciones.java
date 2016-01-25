
package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaSecciones {
    //Metodo para Obtener Arralist de Secciones
    public ArrayList<Seccion> listarSecciones() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_seccion WHERE estado_secc LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Secciones en ArrayList");
        }
    }
    
    ////Buscar Secciones por Codigo
    public Seccion buscarSeccionPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_seccion WHERE "
                    + "codigo_secc='"+codigo+"' AND estado_secc LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Secciones por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Seccion Crear(ResultSet rs) {
        Seccion obj;
        try {
            obj = new Seccion();
            obj.setCodigo(rs.getLong("codigo_secc"));
            obj.setNombre(rs.getString("nombre_secc"));
            obj.setDescripcion(rs.getString("descripcion_secc"));
            obj.setEstado(rs.getString("estado_secc").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
