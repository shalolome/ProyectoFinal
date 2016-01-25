
package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Profesion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaProfesion {
    //Metodo para Obtener Arralist de Profesiones
    public ArrayList<Profesion> listarProfesiones() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_profesion WHERE estado_prof LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Profesiones en ArrayList");
        }
    }
    
    ////Buscar Profesiones por Codigo
    public Profesion buscarProfesionPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_profesion WHERE "
                    + "codigo_prof='"+codigo+"' AND estado_prof LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Profesiones por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Profesion Crear(ResultSet rs) {
        Profesion obj;
        try {
            obj = new Profesion();
            obj.setCodigo(rs.getLong("codigo_prof"));
            obj.setNombre(rs.getString("nombre_prof"));
            obj.setDescripcion(rs.getString("descripcion_prof"));
            obj.setEstado(rs.getString("estado_prof").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
