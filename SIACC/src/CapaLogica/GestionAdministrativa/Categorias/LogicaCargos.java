
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Cargos;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaCargos {
    //Metodo para Obtener Arralist de Cargos
    public ArrayList<Cargos> listarCargos() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_cargo WHERE estado_carg LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Cargos en ArrayList");
        }
    }
    
    ////Buscar Cargos por Codigo
    public Cargos buscarCargoPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_cargo WHERE "
                    + "codigo_carg='"+codigo+"' AND estado_carg LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Cargos por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Cargos Crear(ResultSet rs) {
        Cargos obj;
        try {
            obj = new Cargos();
            obj.setCodigo(rs.getLong("codigo_carg"));
            obj.setNombre(rs.getString("nombre_carg"));
            obj.setEstado(rs.getString("estado_carg").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
