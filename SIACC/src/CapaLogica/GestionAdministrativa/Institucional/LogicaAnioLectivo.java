
package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaAnioLectivo {
    
    //Metodo para Insertar Periodo Lectivo
    public void Insertar(AnioLectivo obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_anio_lectivo(ainicio_alec,afin_alec, descipcion_alec ,estado_alec) "
                    + "values('" + obj.getAnioInicio()+ "',"
                    + "'" + obj.getAnioFin()+ "',"
                    + "'" + obj.getDescripcion() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Periodo Lectivo...");
        }
    }
    
    ///Actualizar Periodo Lectivo
    public void Actualizar(AnioLectivo obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_anio_lectivo "
                    + "set ainicio_alec='" + obj.getAnioInicio()+ "', "
                    + "afin_alec='" + obj.getAnioFin()+ "' ,"
                    + "descipcion_alec='" + obj.getDescripcion() + "' "
                    + "where codigo_alec='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Periodo Lectivo");
        }
    }
    
    //Metodo para Obtener Arralist de Año Lectivo
    public ArrayList<AnioLectivo> listarAnioLectivo() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_anio_lectivo WHERE estado_alec LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Año Lectivo en ArrayList");
        }
    }
    
    //Metodo para Listar Periodo Lectivo
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_alec, ainicio_alec, afin_alec \n"
                    + "FROM siacc_anio_lectivo WHERE estado_alec LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][3];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_alec");
                obj[i][1] = rs.getString("ainicio_alec");
                obj[i][2] = rs.getString("afin_alec");
              
                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Periodo Lectivo...");
        }
    }
    
    ////Buscar Año Lectivo por Codigo
    public AnioLectivo buscarAnioLectivoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_anio_lectivo WHERE "
                    + "codigo_alec='"+codigo+"' AND estado_alec LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Años Lectivos por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private AnioLectivo Crear(ResultSet rs) {
        AnioLectivo obj;
        try {
            obj = new AnioLectivo();
            obj.setCodigo(rs.getLong("codigo_alec"));
            obj.setAnioInicio(rs.getString("ainicio_alec"));
            obj.setAnioFin(rs.getString("afin_alec"));
            obj.setDescripcion(rs.getString("descipcion_alec"));
            obj.setEstado(rs.getString("estado_alec").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
