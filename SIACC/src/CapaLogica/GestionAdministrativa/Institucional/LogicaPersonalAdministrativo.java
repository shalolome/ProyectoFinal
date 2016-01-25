package CapaLogica.GestionAdministrativa.Institucional;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Personal;
import java.sql.ResultSet;

public class LogicaPersonalAdministrativo {

    //Metodo para Insertar Personal Administrativo
    public void Insertar(Personal obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_padministrativo(codigo_pers,codigo_prof,codigo_parr,telefono_padm, "
                    + "celular_padm, email_padm, estado_padm) "
                    + "values('" + obj.getCodigo() + "',"
                    + "'" + obj.getCodigoProfesion() + "',"
                    + "'" + obj.getCodigoParroquia() + "',"
                    + "'" + obj.getTelefono() + "',"
                    + "'" + obj.getCelular() + "',"
                    + "'" + obj.getCorreo() + "',"
                    + "'" + obj.getEstadoPersonal()+ "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Personal Administrativo...");
        }
    }
    
    ///Actualizar Personal Administrativo
    public void Actualizar(Personal obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_padministrativo "
                    + "set codigo_pers='" + obj.getCodigo()+ "', "
                    + "codigo_prof='" + obj.getCodigoProfesion()+ "' , "
                    + "codigo_parr='" + obj.getCodigoParroquia()+ "' , "
                    + "telefono_padm='" + obj.getTelefono()+ "' , "
                    + "celular_padm='" + obj.getCelular()+ "' , "
                    + "email_padm='" + obj.getCorreo()+ "' "
                    + "where codigo_padm='" + obj.getCodigoPersonal() + "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Personal Administrativo");
        }
    }

    //Metodo para Listar Personal Administrativo
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_padm,  cedula_pers, pnombre_pers, snombre_pers, amaterno_pers, apaterno_pers, telefono_padm,\n"
                    + "	celular_padm, email_padm, direccion_pers\n"
                    + "FROM siacc_persona INNER JOIN siacc_padministrativo ON siacc_persona.codigo_pers=siacc_padministrativo.codigo_pers\n"
                    + "WHERE estado_padm LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][10];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_padm");
                obj[i][1] = rs.getString("cedula_pers");
                obj[i][2] = rs.getString("pnombre_pers");
                obj[i][3] = rs.getString("snombre_pers");
                obj[i][4] = rs.getString("apaterno_pers");
                obj[i][5] = rs.getString("amaterno_pers");
                obj[i][6] = rs.getString("telefono_padm");
                obj[i][7] = rs.getString("celular_padm");
                obj[i][8] = rs.getString("email_padm");
                obj[i][9] = rs.getString("direccion_pers");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Asignaturas...");
        }
    }
    
    ////Buscar Personal Administrativo por Codigo
    public Personal buscarPersonalPorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_padministrativo WHERE "
                    + "codigo_padm='"+codigo+"' AND estado_padm LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Personal Administrativo por Codigo");
        }
    }
    
    //Metodo para Crear Objeto
    private Personal Crear(ResultSet rs) {
        Personal obj;
        try {
            obj = new Personal();
            obj.setCodigoPersonal(rs.getLong("codigo_padm"));
            obj.setCodigo(rs.getLong("codigo_pers"));
            obj.setCodigoProfesion(rs.getLong("codigo_prof"));
            obj.setCodigoParroquia(rs.getLong("codigo_parr"));
            obj.setTelefono(rs.getString("telefono_padm"));
            obj.setCelular(rs.getString("celular_padm"));
            obj.setCorreo(rs.getString("email_padm"));
            obj.setEstadoPersonal(rs.getString("estado_padm").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
