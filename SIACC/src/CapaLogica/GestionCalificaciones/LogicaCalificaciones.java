package CapaLogica.GestionCalificaciones;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionCalificaciones.Calificaciones;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaCalificaciones {

    //Metodo para Insertar Calificaciones
    public void Insertar(Calificaciones obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_calificaciones(codigo_matr,codigo_dist,codigo_tnot, "
                    + "codigo_paca, nota_cali, estado_cali) "
                    + "values('" + obj.getCodigoMatricula() + "',"
                    + "'" + obj.getCodigoDistributivo() + "',"
                    + "'" + obj.getCodigoTipoNota() + "',"
                    + "'" + obj.getCodigoPeriodoAcedemico() + "',"
                    + "'" + obj.getNota() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Calificacion...");
        }
    }

    ///Actualizar Calificacion
    public void Actualizar(Calificaciones obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_calificaciones "
                    + "set codigo_matr='" + obj.getCodigoMatricula() + "', "
                    + "codigo_dist='" + obj.getCodigoDistributivo() + "', "
                    + "codigo_tnot='" + obj.getCodigoTipoNota() + "', "
                    + "codigo_paca='" + obj.getCodigoPeriodoAcedemico() + "', "
                    + "nota_cali='" + obj.getNota() + "' "
                    + "where codigo_cali='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Calificacion");
        }
    }

    ////Buscar Calificaciones por Tipo de Nota
    public Calificaciones buscarNotaPorTipo(long codMatri, long codDistr, long codPeriod, long codTipNot) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT SUM(nota_cali) / COUNT(*) AS nota_cali FROM siacc_calificaciones \n"
                    + "WHERE codigo_matr='"+codMatri+"' AND codigo_tnot='"+codTipNot+"' AND codigo_paca='"+codPeriod+"'\n"
                    + "AND codigo_dist='"+codDistr+"' AND estado_cali LIKE 'A'");
            if (rs.next()) {
                return CrearTotalNota(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Nota por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Calificaciones Crear(ResultSet rs) {
        Calificaciones obj;
        try {
            obj = new Calificaciones();
            obj.setCodigo(rs.getLong("codigo_cali"));
            obj.setCodigoDistributivo(rs.getLong("codigo_dist"));
            obj.setCodigoMatricula(rs.getLong("codigo_matr"));
            obj.setCodigoTipoNota(rs.getLong("codigo_tnot"));
            obj.setCodigoPeriodoAcedemico(rs.getLong("codigo_paca"));
            obj.setNota(rs.getFloat("nota_cali"));
            obj.setEstado(rs.getString("estado_cali").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
    
    //Metodo para Crear Objeto
    private Calificaciones CrearTotalNota(ResultSet rs) {
        Calificaciones obj;
        try {
            obj = new Calificaciones();
            
            obj.setTotalNota(rs.getString("nota_cali"));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
