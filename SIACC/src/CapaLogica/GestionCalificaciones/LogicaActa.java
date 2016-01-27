package CapaLogica.GestionCalificaciones;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionCalificaciones.Acta;
import java.sql.ResultSet;

public class LogicaActa {

    //Metodo para Insertar Acta
    public long InsertGetId(Acta obj) {
        try {
            Conexion conexionBD = new Conexion();
            return conexionBD.InsertGetID("insert into siacc_actacalificaciones "
                    + "(codigo_paca, codigo_distr, fregistro_acal, "
                    + " estado_acal) "
                    + "values('" + obj.getCodigoPeriodo() + "',"
                    + "'" + obj.getCodigoDistributivo() + "',"
                    + "'" + obj.getFechaRegistro() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Acta y Capturar ID");
        }
    }

    ///Actualizar Acta
    public void Actualizar(Acta obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_actacalificaciones "
                    + "set codigo_paca='" + obj.getCodigoPeriodo() + "', "
                    + "codigo_distr='" + obj.getCodigoDistributivo() + "' , "
                    + "fregistro_acal='" + obj.getFechaRegistro() + "' "
                    + "where codigo_acal='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Acta");
        }
    }

    //Metodo para Listar Acta
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_acal, CONCAT(pnombre_pers, ' ', snombre_pers, ' ', apaterno_pers, ' ', amaterno_pers) AS docente,\n"
                    + "CONCAT(nombre_curs, ' ', nombre_para, ' ', nombre_secc, ' ', ainicio_alec, ' - ', afin_alec) AS curso, nombre_asig,\n"
                    + "nombre_paca, fregistro_acal\n"
                    + "FROM siacc_actacalificaciones\n"
                    + "INNER JOIN siacc_periodoacademico ON siacc_actacalificaciones.codigo_paca=siacc_periodoacademico.codigo_paca\n"
                    + "INNER JOIN siacc_distributivo ON siacc_actacalificaciones.codigo_distr=siacc_distributivo.codigo_dist\n"
                    + "INNER JOIN siacc_grado ON siacc_distributivo.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_cursos.codigo_curs=siacc_grado.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_paralelo.codigo_para=siacc_grado.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_seccion.codigo_secc=siacc_grado.codigo_secc\n"
                    + "INNER JOIN siacc_anio_lectivo ON siacc_anio_lectivo.codigo_alec=siacc_grado.codigo_alec\n"
                    + "INNER JOIN siacc_malla ON siacc_malla.codigo_mall=siacc_distributivo.codigo_mall\n"
                    + "INNER JOIN siacc_asignatura ON siacc_asignatura.codigo_asig=siacc_malla.codigo_asig\n"
                    + "INNER JOIN siacc_asigcargos ON siacc_distributivo.codigo_acar=siacc_asigcargos.codigo_acar\n"
                    + "INNER JOIN siacc_padministrativo ON siacc_asigcargos.codigo_padm=siacc_padministrativo.codigo_padm\n"
                    + "INNER JOIN siacc_persona ON siacc_padministrativo.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_acal LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][6];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_acal");
                obj[i][1] = rs.getString("docente");
                obj[i][2] = rs.getString("curso");
                obj[i][3] = rs.getString("nombre_asig");
                obj[i][4] = rs.getString("nombre_paca");
                obj[i][5] = rs.getString("fregistro_acal");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Actas Parciales...");
        }
    }

    ////Buscar Acta por Codigo
    public Acta buscarActaPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_actacalificaciones WHERE "
                    + "codigo_acal='" + codigo + "' AND estado_acal LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Acta por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Acta Crear(ResultSet rs) {
        Acta obj;
        try {
            obj = new Acta();
            obj.setCodigo(rs.getLong("codigo_acal"));
            obj.setCodigoPeriodo(rs.getLong("codigo_paca"));
            obj.setCodigoDistributivo(rs.getLong("codigo_distr"));
            obj.setFechaRegistro(rs.getString("fregistro_acal"));
            obj.setEstado(rs.getString("estado_acal").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
