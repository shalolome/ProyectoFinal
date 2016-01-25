
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Provincia;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaProvincia {
    //Metodo para Obtener Arralist de Provincia
    public ArrayList<Provincia> listarProvincias() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_provincia WHERE estado_prov LIKE 'A' AND codigo_pais=1");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Provincia en ArrayList");
        }
    }
    
    ////Buscar Provincia por Codigo
    public Provincia buscarProvinciaPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_provincia WHERE "
                    + "codigo_prov='"+codigo+"' AND estado_prov LIKE 'A' AND codigo_pais=1");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Provincias por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Provincia Crear(ResultSet rs) {
        Provincia obj;
        try {
            obj = new Provincia();
            obj.setCodigoProvincia(rs.getLong("codigo_prov"));
            obj.setCodigo(rs.getLong("codigo_pais"));
            obj.setNombreProvincia(rs.getString("nombre_prov"));
            obj.setEstadoProvincia(rs.getString("estado_prov").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
