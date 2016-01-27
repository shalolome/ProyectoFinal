package CapaLogica.GestionSeguridad;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Distributivo;
import CapaDatos.Entidades.GestionSeguridad.Usuario;
import java.sql.ResultSet;

public class LogicaUsuario {

    //Metodo para Insertar Usuario
    public void Insertar(Usuario obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_usuario(nick_usua,clave_usua, "
                    + "estado_usua) "
                    + "values('" + obj.getNick()+ "',"
                    + "'" + obj.getClave() + "',"
                    + "'" + obj.getEstado() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Usuario...");
        }
    }

    ///Actualizar Usuario
    public void Actualizar(Usuario obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_usuario "
                    + "set nick_usua='" + obj.getNick()+ "', "
                    + "clave_usua='" + obj.getClave()+ "' "
                    + "where codigo_usua='" + obj.getCodigo() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Usuario");
        }
    }

    ////Buscar Usuario por Codigo
    public Usuario buscarUsuPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_usuario WHERE "
                    + "codigo_usua='" + codigo + "' AND estado_usua LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Usuario por Codigo");
        }
    }

    ////Buscar Usuario por Nick y Clave
    public Usuario loginUsuario(String nick, String clave) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_usuario\n"
                    + "WHERE nick_usua LIKE '"+nick+"' AND clave_usua LIKE '"+clave+"' AND estado_usua LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Usuario por Nock y Clave");
        }
    }
    
    //Metodo para Crear Objeto
    private Usuario Crear(ResultSet rs) {
        Usuario obj;
        try {
            obj = new Usuario();
            obj.setCodigo(rs.getLong("codigo_usua"));
            obj.setNick(rs.getString("nick_usua"));
            obj.setClave(rs.getString("clave_usua"));
            obj.setEstado(rs.getString("estado_usua").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
