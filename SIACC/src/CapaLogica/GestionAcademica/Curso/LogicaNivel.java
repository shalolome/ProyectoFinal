
package CapaLogica.GestionAcademica.Curso;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaNivel {
    //Metodo para Obtener Arralist de Niveles o Cursos
    public ArrayList<Nivel> listarNiveles() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_cursos WHERE estado_curs LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Niveles o Cursos en ArrayList");
        }
    }
    
    ////Buscar Niveles o Cursos por Codigo
    public Nivel buscarNivelPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_cursos WHERE "
                    + "codigo_curs='"+codigo+"' AND estado_curs LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Niveles o Cursos por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Nivel Crear(ResultSet rs) {
        Nivel obj;
        try {
            obj = new Nivel();
            obj.setCodigo(rs.getLong("codigo_curs"));
            obj.setNombre(rs.getString("nombre_curs"));
            obj.setDescripcion(rs.getString("descripcion_curs"));
            obj.setEstado(rs.getString("estado_curs").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
