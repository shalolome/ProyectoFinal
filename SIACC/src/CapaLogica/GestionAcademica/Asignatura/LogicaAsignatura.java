
package CapaLogica.GestionAcademica.Asignatura;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Asignatura;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaAsignatura {
    
    //Metodo para Insertar Asignatura
    public void Insertar(Asignatura obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_asignatura(nombre_asig,descripcion_asig,estado_asig) "
                    + "values('" + obj.getNombre()+ "',"
                    + "'" + obj.getDescripcion() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Asignatura...");
        }
    }
    
    ///Actualizar Asignatura
    public void Actualizar(Asignatura obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_asignatura "
                    + "set nombre_asig='" + obj.getNombre() + "', "
                    + "descripcion_asig='" + obj.getDescripcion() + "' "
                    + "where codigo_asig='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Asignatura");
        }
    }
    
    //Metodo para Listar Materias
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_asig, nombre_asig, descripcion_asig\n"
                    + "FROM siacc_asignatura WHERE estado_asig LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_asig");
                obj[i][1] = rs.getString("nombre_asig");
                obj[i][2] = rs.getString("descripcion_asig");
              
                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Asignaturas...");
        }
    }
    
    //Metodo para Obtener Arralist de Asignaturas
    public ArrayList<Asignatura> listarAsignatura() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_asignatura WHERE estado_asig LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Asignaturas en ArrayList");
        }
    }
    
    ////Buscar Asignaturas por Codigo
    public Asignatura buscarAsignaturaPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_asignatura WHERE "
                    + "codigo_asig='"+codigo+"' AND estado_asig LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Asignaturas por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Asignatura Crear(ResultSet rs) {
        Asignatura obj;
        try {
            obj = new Asignatura();
            obj.setCodigo(rs.getLong("codigo_asig"));
            obj.setNombre(rs.getString("nombre_asig"));
            obj.setDescripcion(rs.getString("descripcion_asig"));
            obj.setEstado(rs.getString("estado_asig").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
