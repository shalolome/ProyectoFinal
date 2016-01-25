package CapaLogica.GestionEstudiantil;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionEstudiantil.Estudiantes;
import java.sql.ResultSet;

public class LogicaEstudiante {

    //Metodo para Insertar Estudiante
    public void Insertar(Estudiantes obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_estudiante(codigo_pers,codigo_parr,cmagisterio_estu,fnacimiento_estu, "
                    + " estado_estu) "
                    + "values('" + obj.getCodigo() + "',"
                    + "'" + obj.getCodigoParroquia() + "',"
                    + "'" + obj.getCodigoMagisterio() + "',"
                    + "'" + obj.getFechaNacimiento() + "',"
                    + "'" + obj.getEstadoEstudiante()+ "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Estudiante...");
        }
    }

    ///Actualizar Estudiante
    public void Actualizar(Estudiantes obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_estudiante "
                    + "set codigo_pers='" + obj.getCodigo() + "', "
                    + "codigo_parr='" + obj.getCodigoParroquia() + "' , "
                    + "cmagisterio_estu='" + obj.getCodigoMagisterio() + "' , "
                    + "fnacimiento_estu='" + obj.getFechaNacimiento() + "' "
                    + "where codigo_estu='" + obj.getCodigoEstudiante() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Estudiante");
        }
    }

    //Metodo para Listar Estudiante
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_estu, cedula_pers, pnombre_pers, snombre_pers, amaterno_pers, apaterno_pers, nombre_gene,\n"
                    + "fnacimiento_estu, direccion_pers\n"
                    + "FROM siacc_persona INNER JOIN siacc_estudiante ON siacc_persona.codigo_pers=siacc_estudiante.codigo_pers\n"
                    + "INNER JOIN siacc_genero ON siacc_persona.sexo_pers=siacc_genero.codigo_gene\n"
                    + "WHERE estado_estu LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][9];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_estu");
                obj[i][1] = rs.getString("cedula_pers");
                obj[i][2] = rs.getString("pnombre_pers");
                obj[i][3] = rs.getString("snombre_pers");
                obj[i][4] = rs.getString("apaterno_pers");
                obj[i][5] = rs.getString("amaterno_pers");
                obj[i][6] = rs.getString("nombre_gene");
                obj[i][7] = rs.getString("fnacimiento_estu");
                obj[i][8] = rs.getString("direccion_pers");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Estudiantes...");
        }
    }

    ////Buscar Estudiante por Codigo
    public Estudiantes buscarEstudiantePorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_estudiante WHERE "
                    + "codigo_estu='" + codigo + "' AND estado_estu LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Estudiantes por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Estudiantes Crear(ResultSet rs) {
        Estudiantes obj;
        try {
            obj = new Estudiantes();
            obj.setCodigoEstudiante(rs.getLong("codigo_estu"));
            obj.setCodigo(rs.getLong("codigo_pers"));
            obj.setCodigoParroquia(rs.getLong("codigo_parr"));
            obj.setCodigoMagisterio(rs.getString("cmagisterio_estu"));
            obj.setFechaNacimiento(rs.getString("fnacimiento_estu"));
            obj.setEstadoEstudiante(rs.getString("estado_estu").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
