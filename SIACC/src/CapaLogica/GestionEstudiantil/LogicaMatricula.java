package CapaLogica.GestionEstudiantil;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionEstudiantil.Matricula;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaMatricula {

    //Metodo para Insertar Matricula
    public void Insertar(Matricula obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_matricula(codigo_estu,codigo_grad, codigo_fami, fregistro_matr, "
                    + "estado_matr) "
                    + "values('" + obj.getCodigoEstudiante() + "',"
                    + "'" + obj.getCodigoGrado() + "',"
                    + "'" + obj.getCodigoRepresentante() + "',"
                    + "'" + obj.getFechaRegistro() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Matricula...");
        }
    }

    ///Actualizar Matricula
    public void Actualizar(Matricula obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_matricula "
                    + "set codigo_estu='" + obj.getCodigoEstudiante() + "', "
                    + "codigo_grad='" + obj.getCodigoGrado() + "', "
                    + "codigo_fami='" + obj.getCodigoRepresentante() + "', "
                    + "fregistro_matr='" + obj.getFechaRegistro() + "' "
                    + "where codigo_matr='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Matricula");
        }
    }

    //Metodo para Listar Matricula
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_matr, cedula_pers, pnombre_pers, snombre_pers, apaterno_pers, amaterno_pers,\n"
                    + "nombre_curs, nombre_para, nombre_secc\n"
                    + "FROM siacc_matricula INNER JOIN siacc_grado ON siacc_matricula.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_grado.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_grado.codigo_para=siacc_paralelo.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_grado.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "INNER JOIN siacc_estudiante ON siacc_matricula.codigo_estu=siacc_estudiante.codigo_estu\n"
                    + "INNER JOIN siacc_persona ON siacc_estudiante.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_matr LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][9];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_matr");
                obj[i][1] = rs.getString("cedula_pers");
                obj[i][2] = rs.getString("pnombre_pers");
                obj[i][3] = rs.getString("snombre_pers");
                obj[i][4] = rs.getString("apaterno_pers");
                obj[i][5] = rs.getString("amaterno_pers");
                obj[i][6] = rs.getString("nombre_curs");
                obj[i][7] = rs.getString("nombre_para");
                obj[i][8] = rs.getString("nombre_secc");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Matriculas...");
        }
    }

    //Metodo para Listar Matricula Estuadiante
    public Object[][] ListarEstudiante(long codGrado) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_matr, CONCAT(pnombre_pers, ' ' ,snombre_pers, ' ',apaterno_pers, ' ',amaterno_pers) AS estudiante\n"
                    + "FROM siacc_matricula INNER JOIN siacc_grado ON siacc_matricula.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_grado.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_grado.codigo_para=siacc_paralelo.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_grado.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "INNER JOIN siacc_estudiante ON siacc_matricula.codigo_estu=siacc_estudiante.codigo_estu\n"
                    + "INNER JOIN siacc_persona ON siacc_estudiante.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_matr LIKE 'A' AND siacc_grado.codigo_grad='" + codGrado + "'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][2];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_matr");
                obj[i][1] = rs.getString("estudiante");
                
                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Estudiantes Matriculados...");
        }
    }

    //Metodo para Listar Matricula por Grado
    public Object[][] ListarPorGrado(long codGrado) {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_matr, cedula_pers, pnombre_pers, snombre_pers, apaterno_pers, amaterno_pers,\n"
                    + "nombre_curs, nombre_para, nombre_secc\n"
                    + "FROM siacc_matricula INNER JOIN siacc_grado ON siacc_matricula.codigo_grad=siacc_grado.codigo_grad\n"
                    + "INNER JOIN siacc_cursos ON siacc_grado.codigo_curs=siacc_cursos.codigo_curs\n"
                    + "INNER JOIN siacc_paralelo ON siacc_grado.codigo_para=siacc_paralelo.codigo_para\n"
                    + "INNER JOIN siacc_seccion ON siacc_grado.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "INNER JOIN siacc_estudiante ON siacc_matricula.codigo_estu=siacc_estudiante.codigo_estu\n"
                    + "INNER JOIN siacc_persona ON siacc_estudiante.codigo_pers=siacc_persona.codigo_pers\n"
                    + "WHERE estado_matr LIKE 'A' AND siacc_grado.codigo_grad='" + codGrado + "'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][9];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_matr");
                obj[i][1] = rs.getString("cedula_pers");
                obj[i][2] = rs.getString("pnombre_pers");
                obj[i][3] = rs.getString("snombre_pers");
                obj[i][4] = rs.getString("apaterno_pers");
                obj[i][5] = rs.getString("amaterno_pers");
                obj[i][6] = rs.getString("nombre_curs");
                obj[i][7] = rs.getString("nombre_para");
                obj[i][8] = rs.getString("nombre_secc");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Matriculas por Grados...");
        }
    }

    ////Buscar Matricula por Codigo
    public Matricula buscarMatriculaPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_matricula WHERE "
                    + "codigo_matr='" + codigo + "' AND estado_matr LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Matricula por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Matricula Crear(ResultSet rs) {
        Matricula obj;
        try {
            obj = new Matricula();
            obj.setCodigo(rs.getLong("codigo_matr"));
            obj.setCodigoEstudiante(rs.getLong("codigo_estu"));
            obj.setCodigoGrado(rs.getLong("codigo_grad"));
            obj.setCodigoRepresentante(rs.getLong("codigo_fami"));
            obj.setFechaRegistro(rs.getString("fregistro_matr"));
            obj.setEstado(rs.getString("estado_matr").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
