
package CapaLogica.GestionAcademica.Curso;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogicaParalelo {
    //Metodo para Obtener Arralist de Paralelo
    public ArrayList<Paralelo> listarParalelo() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT * FROM siacc_paralelo WHERE estado_para LIKE 'A'");

            ArrayList listar = new ArrayList();
            while (rs.next()) {
                listar.add(Crear(rs));
            }
            return listar;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Paralelos en ArrayList");
        }
    }
    
    ////Buscar Paralelo por Codigo
    public Paralelo buscarParaleloPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_paralelo WHERE "
                    + "codigo_para='"+codigo+"' AND estado_para LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Paralelos por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Paralelo Crear(ResultSet rs) {
        Paralelo obj;
        try {
            obj = new Paralelo();
            obj.setCodigo(rs.getLong("codigo_para"));
            obj.setNombre(rs.getString("nombre_para"));
            obj.setEstado(rs.getString("estado_para").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
