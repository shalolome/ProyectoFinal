
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Pais;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaPais {
    //Metodo para Obtener Arralist de Pais
    public ArrayList<Pais> listarPaises() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_pais WHERE estado_pais LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Pais en ArrayList");
        }
    }
    
    ////Buscar Pais por Codigo
    public Pais buscarPaisPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_pais WHERE "
                    + "codigo_pais='"+codigo+"' AND estado_pais LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Paises por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Pais Crear(ResultSet rs) {
        Pais obj;
        try {
            obj = new Pais();
            obj.setCodigo(rs.getLong("codigo_pais"));
            obj.setNombre(rs.getString("nombre_pais"));
            obj.setEstado(rs.getString("estado_pais").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
