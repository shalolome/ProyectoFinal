package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AsignacionSecciones;
import java.sql.ResultSet;

public class LogicaAsignacionSeccion {

    //Metodo para Insertar Asignación de Secciones
    public void Insertar(AsignacionSecciones obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_asigseccion(codigo_inst,codigo_secc, descripcion_asec, estado_asec) "
                    + "values('" + obj.getCodigoInstitucion() + "',"
                    + "'" + obj.getCodigoSeccion() + "',"
                    + "'" + obj.getDescripcion() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Asignación de Secciones...");
        }
    }

    ///Actualizar Asignación de Secciones
    public void Actualizar(AsignacionSecciones obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_asigseccion "
                    + "set codigo_inst='" + obj.getCodigoInstitucion() + "', "
                    + "codigo_secc='" + obj.getCodigoSeccion() + "' , "
                    + "descripcion_asec='" + obj.getDescripcion() + "' "
                    + "where codigo_asec='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Asignación de Secciones");
        }
    }

    //Metodo para Listar Asignación de Secciones
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_asec, nombre_secc, descripcion_asec\n"
                    + "FROM siacc_asigseccion INNER JOIN siacc_seccion ON siacc_asigseccion.codigo_secc=siacc_seccion.codigo_secc\n"
                    + "WHERE estado_asec LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_asec");
                obj[i][1] = rs.getString("nombre_secc");
                obj[i][2] = rs.getString("descripcion_asec");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Asignación de Secciones...");
        }
    }

    ////Buscar Asignación de Secciones por Codigo
    public AsignacionSecciones buscarAsigSeccionPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_asigseccion WHERE "
                    + "codigo_asec='" + codigo + "' AND estado_asec LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Asignación de Secciones por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private AsignacionSecciones Crear(ResultSet rs) {
        AsignacionSecciones obj;
        try {
            obj = new AsignacionSecciones();
            obj.setCodigo(rs.getLong("codigo_asec"));
            obj.setCodigoInstitucion(rs.getLong("codigo_inst"));
            obj.setCodigoSeccion(rs.getLong("codigo_secc"));
            obj.setDescripcion(rs.getString("descripcion_asec"));
            obj.setEstado(rs.getString("estado_asec").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
