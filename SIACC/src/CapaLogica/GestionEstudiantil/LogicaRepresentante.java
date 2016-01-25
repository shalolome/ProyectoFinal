package CapaLogica.GestionEstudiantil;

import CapaDatos.ConexionBD.Conexion;
import CapaDatos.Entidades.GestionEstudiantil.Estudiantes;
import CapaDatos.Entidades.GestionEstudiantil.Representantes;
import java.sql.ResultSet;

public class LogicaRepresentante {

    //Metodo para Insertar Representante
    public void Insertar(Representantes obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("insert into siacc_familiar(codigo_pers, codigo_parr, telefono_fami, celular_fami, "
                    + " email_fami, estado_fami) "
                    + "values('" + obj.getCodigo() + "',"
                    + "'" + obj.getCodigoParroquia() + "',"
                    + "'" + obj.getTelefono() + "',"
                    + "'" + obj.getCelular() + "',"
                    + "'" + obj.getEmail() + "',"
                    + "'" + obj.getEstadoRepresentante() + "')");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Insertar Representante...");
        }
    }

    ///Actualizar Representante
    public void Actualizar(Representantes obj) {
        try {
            Conexion conexionBD = new Conexion();
            conexionBD.EjecutarSql("update siacc_familiar "
                    + "set codigo_pers='" + obj.getCodigo() + "', "
                    + "codigo_parr='" + obj.getCodigoParroquia() + "' , "
                    + "telefono_fami='" + obj.getTelefono() + "' , "
                    + "celular_fami='" + obj.getCelular()+ "' , "
                    + "email_fami='" + obj.getEmail()+ "' "
                    + "where codigo_fami='" + obj.getCodigoRepresentante()+ "'");
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Representante");
        }
    }

    //Metodo para Listar Representante
    public Object[][] Listar() {
        try {
            Conexion conexion = new Conexion();
            ResultSet rs = conexion.Consulta("SELECT codigo_fami, cedula_pers, pnombre_pers, snombre_pers, amaterno_pers, apaterno_pers, telefono_fami,\n"
                    + "celular_fami, email_fami, direccion_pers\n"
                    + "FROM siacc_persona INNER JOIN siacc_familiar ON siacc_persona.codigo_pers=siacc_familiar.codigo_pers\n"
                    + "WHERE estado_fami LIKE 'A'");
            rs.last();
            Object[][] obj = new Object[rs.getRow()][10];
            rs.beforeFirst();
            int i = 0;

            while (rs.next()) {
                obj[i][0] = rs.getString("codigo_fami");
                obj[i][1] = rs.getString("cedula_pers");
                obj[i][2] = rs.getString("pnombre_pers");
                obj[i][3] = rs.getString("snombre_pers");
                obj[i][4] = rs.getString("apaterno_pers");
                obj[i][5] = rs.getString("amaterno_pers");
                obj[i][6] = rs.getString("telefono_fami");
                obj[i][7] = rs.getString("celular_fami");
                obj[i][8] = rs.getString("email_fami");
                obj[i][9] = rs.getString("direccion_pers");

                i++;
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener Listado de Representantes...");
        }
    }

    ////Buscar Representates por Codigo
    public Representantes buscarReprentantePorCod(long codigo) {
        try {
            Conexion conexionBD = new Conexion();
            ResultSet rs = conexionBD.Consulta("SELECT * FROM siacc_familiar WHERE "
                    + "codigo_fami='" + codigo + "' AND estado_fami LIKE 'A'");
            if (rs.next()) {
                return Crear(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Obtener Representante por Codigo");
        }
    }

    //Metodo para Crear Objeto
    private Representantes Crear(ResultSet rs) {
        Representantes obj;
        try {
            obj = new Representantes();
            obj.setCodigoRepresentante(rs.getLong("codigo_fami"));
            obj.setCodigo(rs.getLong("codigo_pers"));
            obj.setCodigoParroquia(rs.getLong("codigo_parr"));
            obj.setTelefono(rs.getString("telefono_fami"));
            obj.setCelular(rs.getString("celular_fami"));
            obj.setEmail(rs.getString("email_fami"));
            obj.setEstadoRepresentante(rs.getString("estado_fami").charAt(0));

            return obj;
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Objeto");
        }
    }
}
