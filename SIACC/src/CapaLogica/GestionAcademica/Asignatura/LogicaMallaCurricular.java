package CapaLogica.GestionAcademica.Asignatura;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaMallaCurricular {

    //Metodo para Insertar Malla Curricular
    public void Insertar(Malla obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_malla(codigo_asig,codigo_curs,nombre_mall, "
                    + "descripcion_mall, estado_mall) "
                    + "values('" + obj.getCodigoAsignatura()+ "',"
                    + "'" + obj.getCodigoCurso()+ "',"
                    + "'" + obj.getNombre()+ "',"
                    + "'" + obj.getDescripcion()+ "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Malla Curricular...");
        }
    }

    ///Actualizar Malla Curricular
    public void Actualizar(Malla obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_malla "
                    + "set codigo_asig='" + obj.getCodigoAsignatura() + "', "
                    + "codigo_curs='" + obj.getCodigoCurso() + "', "
                    + "nombre_mall='" + obj.getNombre() + "', "
                    + "descripcion_mall='" + obj.getDescripcion() + "' "
                    + "where codigo_mall='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Malla Curricular");
        }
    }

    //Metodo para Listar Malla Curricular
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_mall, nombre_asig, nombre_curs\n"
                    + "FROM siacc_malla INNER JOIN siacc_asignatura ON siacc_malla.codigo_asig=siacc_asignatura.codigo_asig\n"
                    + "INNER JOIN siacc_cursos ON siacc_malla.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "WHERE estado_mall LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_mall");
                obj[i][1] = rs.getString("nombre_asig");
                obj[i][2] = rs.getString("nombre_curs");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Mallas Curriculares...");
        }
    }
    
    //Metodo para Listar por Codigo de Curso Malla Curricular
    public Object[][] ListarPorCod(long codCurso) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_mall, nombre_asig, nombre_curs\n"
                    + "FROM siacc_malla INNER JOIN siacc_asignatura ON siacc_malla.codigo_asig=siacc_asignatura.codigo_asig\n"
                    + "INNER JOIN siacc_cursos ON siacc_malla.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "WHERE estado_mall LIKE 'A' AND  siacc_malla.codigo_curs ='"+codCurso+"'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_mall");
                obj[i][1] = rs.getString("nombre_asig");
                obj[i][2] = rs.getString("nombre_curs");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado por Codigo de Curso de Mallas Curriculares...");
        }
    }

    ////Buscar Malla Curricular por Codigo
    public Malla buscarMallaPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_malla WHERE "
                    + "codigo_mall='" + codigo + "' AND estado_mall LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Mallas Curriculares por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Malla Crear(ResultSet rs) {
        Malla obj;
        try {
            obj = new Malla();
            obj.setCodigo(rs.getLong("codigo_mall"));
            obj.setCodigoCurso(rs.getLong("codigo_curs"));
            obj.setCodigoAsignatura(rs.getLong("codigo_asig"));
            obj.setNombre(rs.getString("nombre_mall"));
            obj.setDescripcion(rs.getString("descripcion_mall"));
            obj.setEstado(rs.getString("estado_mall").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
