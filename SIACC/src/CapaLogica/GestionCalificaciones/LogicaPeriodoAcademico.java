
package CapaLogica.GestionCalificaciones;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionCalificaciones.PeriodoAcademicos;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaPeriodoAcademico {
    //Metodo para Obtener Arralist de Quimestres
    public ArrayList<PeriodoAcademicos> listarQuimestres() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_periodoacademico WHERE estado_paca LIKE 'A' AND codigopadre_paca IS NULL");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Quimestres en ArrayList");
        }
    }
    
    //Metodo para Obtener Arralist de Parciales
    public ArrayList<PeriodoAcademicos> listarParciales(long codQuimestre) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_periodoacademico WHERE estado_paca LIKE 'A' AND codigopadre_paca='"+codQuimestre+"'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Parciales en ArrayList");
        }
    }
    
    ////Buscar Periodo Academico por Codigo
    public PeriodoAcademicos buscarPeriodoAcademicoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_periodoacademico WHERE "
                    + "codigo_paca='"+codigo+"' AND estado_paca LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Periodo Academico por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private PeriodoAcademicos Crear(ResultSet rs) {
        PeriodoAcademicos obj;
        try {
            obj = new PeriodoAcademicos();
            obj.setCodigo(rs.getLong("codigo_paca"));
            obj.setCodioPadre(rs.getLong("codigopadre_paca"));
            obj.setNombre(rs.getString("nombre_paca"));
            obj.setDescripcion(rs.getString("descripcion_paca"));
            obj.setEstado(rs.getString("estado_paca").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
