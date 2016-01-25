package CapaLogica.GestionAcademica.Asignatura;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Distributivo;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaDistributivo {

    //Metodo para Insertar Distributivo
    public void Insertar(Distributivo obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_distributivo(codigo_mall,codigo_grad,codigo_acar, "
                    + "descrpcion_dist, estado_dist) "
                    + "values('" + obj.getCodigoMallaCurricular() + "',"
                    + "'" + obj.getCodigoGrado() + "',"
                    + "'" + obj.getAsignacionCargo() + "',"
                    + "'" + obj.getDescripcion() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Distributivo...");
        }
    }

    ///Actualizar Distributivo
    public void Actualizar(Distributivo obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_distributivo "
                    + "set codigo_mall='" + obj.getCodigoMallaCurricular() + "', "
                    + "codigo_grad='" + obj.getCodigoGrado() + "', "
                    + "codigo_acar='" + obj.getAsignacionCargo() + "', "
                    + "descrpcion_dist='" + obj.getDescripcion() + "' "
                    + "where codigo_dist='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Distributivo");
        }
    }

    //Metodo para Listar Distributivo
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_dist, CONCAT(pnombre_pers, ' ', snombre_pers, ' ', apaterno_pers, ' ', amaterno_pers) AS docente,\n"
                    + "CONCAT(nombre_curs, ' ', nombre_para, ' ', nombre_secc, ' ', ainicio_alec, ' - ', afin_alec) AS curso, nombre_asig\n"
                    + "FROM siacc_distributivo INNER JOIN siacc_grado ON siacc_distributivo.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_cursos.codigo_curs=siacc_grado.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_paralelo.codigo_para=siacc_grado.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_seccion.codigo_secc=siacc_grado.codigo_secc\n"
                    + "INNER JOIN siacc_anio_lectivo ON siacc_anio_lectivo.codigo_alec=siacc_grado.codigo_alec\n"
                    + "INNER JOIN siacc_malla ON siacc_malla.codigo_mall=siacc_distributivo.codigo_mall\n"
                    + "INNER JOIN siacc_asignatura ON siacc_asignatura.codigo_asig=siacc_malla.codigo_asig\n"
                    + "INNER JOIN siacc_asigcargos ON siacc_distributivo.codigo_acar=siacc_asigcargos.codigo_acar\n"
                    + "INNER JOIN siacc_padministrativo ON siacc_asigcargos.codigo_padm=siacc_padministrativo.codigo_padm\n"
                    + "INNER JOIN siacc_persona ON siacc_padministrativo.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_dist LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][4];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_dist");
                obj[i][1] = rs.getString("docente");
                obj[i][2] = rs.getString("curso");
                obj[i][3] = rs.getString("nombre_asig");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Distributivos...");
        }
    }

    ////Buscar Distributivos por Codigo
    public Distributivo buscarDistributivoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_distributivo WHERE "
                    + "codigo_dist='" + codigo + "' AND estado_dist LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Distributivos por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Distributivo Crear(ResultSet rs) {
        Distributivo obj;
        try {
            obj = new Distributivo();
            obj.setCodigo(rs.getLong("codigo_dist"));
            obj.setCodigoGrado(rs.getLong("codigo_grad"));
            obj.setCodigoMallaCurricular(rs.getLong("codigo_mall"));
            obj.setAsignacionCargo(rs.getLong("codigo_acar"));
            obj.setDescripcion(rs.getString("descrpcion_dist"));
            obj.setEstado(rs.getString("estado_dist").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
