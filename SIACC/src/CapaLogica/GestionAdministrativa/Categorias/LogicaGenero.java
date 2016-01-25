
package CapaLogica.GestionAdministrativa.Categorias;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Genero;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaGenero {
    //Metodo para Obtener Arralist de Generos
    public ArrayList<Genero> listarGeneros() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_genero WHERE estado_gene LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Generos en ArrayList");
        }
    }
    
    ////Buscar Generos por Codigo
    public Genero buscarGeneroPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_genero WHERE "
                    + "codigo_gene='"+codigo+"' AND estado_gene LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Generos por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Genero Crear(ResultSet rs) {
        Genero obj;
        try {
            obj = new Genero();
            obj.setCodigo(rs.getLong("codigo_gene"));
            obj.setNombre(rs.getString("nombre_gene"));
            obj.setEstado(rs.getString("estado_gene").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
