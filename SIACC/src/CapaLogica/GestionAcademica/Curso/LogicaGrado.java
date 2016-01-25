package CapaLogica.GestionAcademica.Curso;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaGrado {

    //Metodo para Insertar Grado
    public void Insertar(Grado obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_grado(codigo_curs,codigo_para,codigo_secc, "
                    + "codigo_alec, nombre_grad, descripcion_grad, estado_grad) "
                    + "values('" + obj.getCodigoNivel() + "',"
                    + "'" + obj.getCodigoParalelo() + "',"
                    + "'" + obj.getCodigoSeccion() + "',"
                    + "'" + obj.getCodigoAnioLectivo() + "',"
                    + "'" + obj.getNombre() + "',"
                    + "'" + obj.getDescripcion() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Grado...");
        }
    }

    ///Actualizar Grado
    public void Actualizar(Grado obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_grado "
                    + "set codigo_curs='" + obj.getCodigoNivel() + "', "
                    + "codigo_para='" + obj.getCodigoParalelo() + "', "
                    + "codigo_secc='" + obj.getCodigoSeccion() + "', "
                    + "codigo_alec='" + obj.getCodigoAnioLectivo() + "', "
                    + "nombre_grad='" + obj.getNombre() + "', "
                    + "descripcion_grad='" + obj.getDescripcion() + "' "
                    + "where codigo_grad='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Grado");
        }
    }

    //Metodo para Listar Grado
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_grad, nombre_secc, nombre_curs, nombre_para, CONCAT(ainicio_alec, ' - ', afin_alec) AS periodo\n"
                    + "FROM siacc_grado INNER JOIN siacc_cursos ON siacc_grado.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_grado.codigo_para=siacc_paralelo.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_grado.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "INNER JOIN siacc_anio_lectivo ON siacc_grado.codigo_alec=siacc_anio_lectivo.codigo_alec\n"
                    + "WHERE estado_grad LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][5];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_grad");
                obj[i][1] = rs.getString("nombre_secc");
                obj[i][2] = rs.getString("nombre_curs");
                obj[i][3] = rs.getString("nombre_para");
                obj[i][4] = rs.getString("periodo");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Grados...");
        }
    }

    ////Buscar Grado por Codigo
    public Grado buscarGradoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_grado WHERE "
                    + "codigo_grad='" + codigo + "' AND estado_grad LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Grados por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Grado Crear(ResultSet rs) {
        Grado obj;
        try {
            obj = new Grado();
            obj.setCodigo(rs.getLong("codigo_grad"));
            obj.setCodigoNivel(rs.getLong("codigo_curs"));
            obj.setCodigoParalelo(rs.getLong("codigo_para"));
            obj.setCodigoSeccion(rs.getLong("codigo_secc"));
            obj.setCodigoAnioLectivo(rs.getLong("codigo_alec"));
            obj.setNombre(rs.getString("nombre_grad"));
            obj.setDescripcion(rs.getString("descripcion_grad"));
            obj.setEstado(rs.getString("estado_grad").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
