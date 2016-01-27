package CapaLogica.GestionCalificaciones;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionCalificaciones.DetalleActaParcial;
import java.sql.ResultSet;

public class LogicaDetalleParcial {

    //Metodo para Insertar Detalle Parcial
    public void Insertar(DetalleActaParcial obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_detalleparcial(codigo_acal, codigo_matr, tai_dpar, iac_dpar, "
                    + " agc_dpar, loe_dpar, evaluacion_dpar, promedio_dpar, estado_dpar) "
                    + "values('" + obj.getCodigoActaParcial() + "',"
                    + "'" + obj.getCodigoMatricula() + "',"
                    + "'" + obj.getNotaTai() + "',"
                    + "'" + obj.getNotaIac() + "',"
                    + "'" + obj.getNotaAgc() + "',"
                    + "'" + obj.getNotaLoe() + "',"
                    + "'" + obj.getEvualuacion() + "',"
                    + "'" + obj.getPromedio() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Detalle Parcial...");
        }
    }

    ///Actualizar Detalle de Acta Parcial
    public void Actualizar(DetalleActaParcial obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_detalleparcial "
                    + "set codigo_acal='" + obj.getCodigoActaParcial() + "', "
                    + "codigo_matr='" + obj.getCodigoMatricula() + "' , "
                    + "tai_dpar='" + obj.getNotaTai() + "' , "
                    + "iac_dpar='" + obj.getNotaIac() + "' , "
                    + "agc_dpar='" + obj.getNotaAgc() + "' , "
                    + "loe_dpar='" + obj.getNotaLoe() + "' , "
                    + "evaluacion_dpar='" + obj.getEvualuacion() + "' , "
                    + "promedio_dpar='" + obj.getPromedio() + "' "
                    + "where codigo_dpar='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Detalle de Acta Parcial");
        }
    }

    //Metodo para Listar por Acta
    public Object[][] ListarPorActa(long codActa) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT siacc_detalleparcial.codigo_matr, CONCAT(pnombre_pers, ' ' ,snombre_pers, ' ' ,apaterno_pers, ' ' ,amaterno_pers) AS estudiante,\n"
                    + "tai_dpar, iac_dpar, agc_dpar, loe_dpar, evaluacion_dpar, promedio_dpar\n"
                    + "FROM siacc_actacalificaciones\n"
                    + "INNER JOIN siacc_detalleparcial ON siacc_actacalificaciones.codigo_acal=siacc_detalleparcial.codigo_acal\n"
                    + "INNER JOIN siacc_matricula ON siacc_detalleparcial.codigo_matr=siacc_matricula.codigo_matr\n"
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
                obj[i][0] = rs.getString("siacc_detalleparcial.codigo_matr");
                obj[i][1] = rs.getString("estudiante");
                obj[i][2] = rs.getString("tai_dpar");
                obj[i][3] = rs.getString("iac_dpar");
                obj[i][4] = rs.getString("agc_dpar");
                obj[i][5] = rs.getString("loe_dpar");
                obj[i][6] = rs.getString("evaluacion_dpar");
                obj[i][7] = rs.getString("promedio_dpar");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Detalle por Acta...");
        }
    }

    ////Buscar Detalle de Acta Parcial por Codigo
    public DetalleActaParcial buscarDetActParcPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_detalleparcial WHERE "
                    + "codigo_dpar='" + codigo + "' AND estado_dpar LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Detalle de Acta Parcial por Codigo");
        }
    }

    ////Buscar Detalle de Promedio Parcial por Codigo
    public DetalleActaParcial buscarDetPromParcPorCod(long codParc, long codMatri, long codDistr) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT promedio_dpar\n"
                    + "FROM siacc_actacalificaciones\n"
                    + "INNER JOIN siacc_detalleparcial ON siacc_actacalificaciones.codigo_acal=siacc_detalleparcial.codigo_acal\n"
                    + "INNER JOIN siacc_matricula ON siacc_detalleparcial.codigo_matr=siacc_matricula.codigo_matr\n"
                    + "INNER JOIN siacc_grado ON siacc_matricula.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_grado.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_grado.codigo_para=siacc_paralelo.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_grado.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "INNER JOIN siacc_estudiante ON siacc_matricula.codigo_estu=siacc_estudiante.codigo_estu\n"
                    + "INNER JOIN siacc_persona ON siacc_estudiante.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_acal LIKE 'A' AND siacc_actacalificaciones.codigo_paca='"+codParc+"'\n"
                    + "AND siacc_detalleparcial.codigo_matr='"+codMatri+"' AND siacc_actacalificaciones.codigo_distr='"+codDistr+"'");
            if (rs.next()) {
                return CrearDetProm(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Detalle de Acta Parcial por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private DetalleActaParcial Crear(ResultSet rs) {
        DetalleActaParcial obj;
        try {
            obj = new DetalleActaParcial();
            obj.setCodigo(rs.getLong("codigo_dpar"));
            obj.setCodigoActaParcial(rs.getLong("codigo_acal"));
            obj.setCodigoMatricula(rs.getLong("codigo_matr"));
            obj.setNotaTai(rs.getFloat("tai_dpar"));
            obj.setNotaIac(rs.getFloat("iac_dpar"));
            obj.setNotaAgc(rs.getFloat("agc_dpar"));
            obj.setNotaLoe(rs.getFloat("loe_dpar"));
            obj.setEvualuacion(rs.getFloat("evaluacion_dpar"));
            obj.setPromedio(rs.getFloat("promedio_dpar"));
            obj.setEstado(rs.getString("estado_dpar").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
    
    //Metodo para Crear Objeto
    private DetalleActaParcial CrearDetProm(ResultSet rs) {
        DetalleActaParcial obj;
        try {
            obj = new DetalleActaParcial();
            obj.setPromedioParcial(rs.getString("promedio_dpar"));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
