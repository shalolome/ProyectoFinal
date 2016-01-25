package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AsigCargos;
import java.sql.ResultSet;

public class LogicaAsignacionCargos {

    //Metodo para Insertar Asignación de Cargos
    public void Insertar(AsigCargos obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_asigcargos(codigo_padm,codigo_carg,estado_acar) "
                    + "values('" + obj.getCodigoPersona() + "',"
                    + "'" + obj.getCodigoCargos() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Asignación de Cargos...");
        }
    }

    ///Actualizar Asignación de Cargos
    public void Actualizar(AsigCargos obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_asigcargos "
                    + "set codigo_padm='" + obj.getCodigoPersona() + "', "
                    + "codigo_carg='" + obj.getCodigoCargos() + "' "
                    + "where codigo_acar='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Asignación de Cargos");
        }
    }

    //Metodo para Listar Asignación de Cargos
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_acar, CONCAT(pnombre_pers,  ' ', snombre_pers, ' ', apaterno_pers, ' ', amaterno_pers) AS personal, nombre_carg\n"
                    + "FROM siacc_asigcargos INNER JOIN siacc_padministrativo ON siacc_asigcargos.codigo_padm=siacc_padministrativo.codigo_padm\n"
                    + "INNER JOIN siacc_persona ON siacc_persona.codigo_pers=siacc_padministrativo.codigo_pers\n"
                    + "INNER JOIN siacc_cargo ON siacc_cargo.codigo_carg=siacc_asigcargos.codigo_carg "
                    + "WHERE estado_acar LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_acar");
                obj[i][1] = rs.getString("personal");
                obj[i][2] = rs.getString("nombre_carg");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Aisgnacion de Cargos...");
        }
    }
    
    //Metodo para Listar Docentes
    public Object[][] Docentes() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_acar, CONCAT(pnombre_pers,  ' ', snombre_pers, ' ', apaterno_pers, ' ', amaterno_pers) AS personal, nombre_carg\n"
                    + "FROM siacc_asigcargos INNER JOIN siacc_padministrativo ON siacc_asigcargos.codigo_padm=siacc_padministrativo.codigo_padm\n"
                    + "INNER JOIN siacc_persona ON siacc_persona.codigo_pers=siacc_padministrativo.codigo_pers\n"
                    + "INNER JOIN siacc_cargo ON siacc_cargo.codigo_carg=siacc_asigcargos.codigo_carg "
                    + "WHERE estado_acar LIKE 'A' AND siacc_asigcargos.codigo_carg=1");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_acar");
                obj[i][1] = rs.getString("personal");
                obj[i][2] = rs.getString("nombre_carg");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Asignaturas...");
        }
    }

    ////Buscar Asignación de Cargos por Codigo
    public AsigCargos buscarAsigCargoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_asigcargos WHERE "
                    + "codigo_acar='" + codigo + "' AND estado_acar LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Asignación de Cargos por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private AsigCargos Crear(ResultSet rs) {
        AsigCargos obj;
        try {
            obj = new AsigCargos();
            obj.setCodigo(rs.getLong("codigo_acar"));
            obj.setCodigoPersona(rs.getLong("codigo_padm"));
            obj.setCodigoCargos(rs.getLong("codigo_carg"));
            obj.setEstado(rs.getString("estado_acar").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
