package CapaLogica.GestionCalificaciones;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionCalificaciones.DetalleActaQuimestre;
import java.sql.ResultSet;

public class LogicaDetalleQuimestre {

    //Metodo para Insertar Detalle Quimestre
    public void Insertar(DetalleActaQuimestre obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_detallequimestre(codigo_acal, codigo_matr, parcial1_dqui, parcial2_dqui, "
                    + " parcial3_dqui, promedio_dqui, examen_dqui, fpromedio_dqui, estado_dqui) "
                    + "values('" + obj.getCodigoActaQuimestre() + "',"
                    + "'" + obj.getCodigoMatricula() + "',"
                    + "'" + obj.getParcial1() + "',"
                    + "'" + obj.getParcial2() + "',"
                    + "'" + obj.getParcial3() + "',"
                    + "'" + obj.getPromedio() + "',"
                    + "'" + obj.getExamen() + "',"
                    + "'" + obj.getPromedioFinal() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Detalle Quimestral...");
        }
    }

    ///Actualizar Detalle de Acta Quimestral
    public void Actualizar(DetalleActaQuimestre obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_detallequimestre "
                    + "set codigo_acal='" + obj.getCodigoActaQuimestre() + "', "
                    + "codigo_matr='" + obj.getCodigoMatricula() + "' , "
                    + "parcial1_dqui='" + obj.getParcial1() + "' , "
                    + "parcial2_dqui='" + obj.getParcial2() + "' , "
                    + "parcial3_dqui='" + obj.getParcial3() + "' , "
                    + "promedio_dqui='" + obj.getPromedio() + "' , "
                    + "examen_dqui='" + obj.getExamen() + "' , "
                    + "fpromedio_dqui='" + obj.getPromedioFinal() + "' "
                    + "where codigo_dqui='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Detalle de Acta Quimestral");
        }
    }

    //Metodo para Listar por Acta
    public Object[][] ListarPorActa(long codActa) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT siacc_detallequimestre.codigo_matr, CONCAT(pnombre_pers, ' ' ,snombre_pers, ' ' ,apaterno_pers, ' ' ,amaterno_pers) AS estudiante,\n"
                    + "parcial1_dqui, parcial2_dqui, parcial3_dqui, promedio_dqui, examen_dqui, fpromedio_dqui\n"
                    + "FROM siacc_actacalificaciones\n"
                    + "INNER JOIN siacc_detallequimestre ON siacc_actacalificaciones.codigo_acal=siacc_detallequimestre.codigo_acal\n"
                    + "INNER JOIN siacc_matricula ON siacc_detallequimestre.codigo_matr=siacc_matricula.codigo_matr\n"
                    + "INNER JOIN siacc_grado ON siacc_matricula.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_grado.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_grado.codigo_para=siacc_paralelo.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_grado.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "INNER JOIN siacc_estudiante ON siacc_matricula.codigo_estu=siacc_estudiante.codigo_estu\n"
                    + "INNER JOIN siacc_persona ON siacc_estudiante.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_acal LIKE 'A' AND siacc_actacalificaciones.codigo_acal='" + codActa + "'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][8];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("siacc_detallequimestre.codigo_matr");
                obj[i][1] = rs.getString("estudiante");
                obj[i][2] = rs.getString("parcial1_dqui");
                obj[i][3] = rs.getString("parcial2_dqui");
                obj[i][4] = rs.getString("parcial3_dqui");
                obj[i][5] = rs.getString("promedio_dqui");
                obj[i][6] = rs.getString("examen_dqui");
                obj[i][7] = rs.getString("fpromedio_dqui");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Detalle por Acta...");
        }
    }

    ////Buscar Detalle de Acta Quimestre por Codigo
    public DetalleActaQuimestre buscarDetActQuimPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_detallequimestre WHERE "
                    + "codigo_dqui='" + codigo + "' AND estado_dqui LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Detalle de Acta Quimestre por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private DetalleActaQuimestre Crear(ResultSet rs) {
        DetalleActaQuimestre obj;
        try {
            obj = new DetalleActaQuimestre();
            obj.setCodigo(rs.getLong("codigo_dqui"));
            obj.setCodigoActaQuimestre(rs.getLong("codigo_acal"));
            obj.setCodigoMatricula(rs.getLong("codigo_matr"));
            obj.setParcial1(rs.getFloat("parcial1_dqui"));
            obj.setParcial2(rs.getFloat("parcial2_dqui"));
            obj.setParcial3(rs.getFloat("parcial3_dqui"));
            obj.setPromedio(rs.getFloat("promedio_dqui"));
            obj.setExamen(rs.getFloat("examen_dqui"));
            obj.setPromedioFinal(rs.getFloat("fpromedio_dqui"));
            obj.setEstado(rs.getString("estado_dqui").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
