
package CapaDatos.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    Connection conn = null;
    public boolean iscon = false;
    Statement stmt_consul = null;

    private String Server = "localhost";
    private String DataBase = "siaac";
    private String User = "root";//usuario del mysql
    private String Password = "root";//contraseÃ±a del mysql
    
    public Connection ConectarBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + Server + "/" + DataBase + "?user=" + User + "&password=" + Password);
            iscon = true;
        } catch (Exception ex) {
//			System.err.println(ex.getMessage());
            throw new RuntimeException("error al conectarse a la base de datos de SIACC");
        }
        return conn;
    }

    public boolean EjecutarSql(String strsql) {
        boolean ok = false;
        Statement stmt_consul = null;
        try {
            if (!iscon) {
                conn = ConectarBD();
            }
            stmt_consul = conn.createStatement();  //crear sentencia
            stmt_consul.executeUpdate(strsql); //ejecuta la sentencia
            ok = true;
            try {
                stmt_consul.close();
                conn.close();
                iscon = false;
            } catch (SQLException sqlEx) {
                ok = false;
                throw new RuntimeException(sqlEx.getMessage());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return ok;
    }

    public long InsertGetID(String strsql) {
        long autoincrementoJava = -1;
        Statement stmt_consul = null;
        try {
            if (!iscon) {
                conn = ConectarBD();
            }
            stmt_consul = conn.createStatement();  //crear sentencia
            stmt_consul.executeUpdate(strsql, Statement.RETURN_GENERATED_KEYS); //ejecuta la sentencia

            ResultSet resulset = stmt_consul.getGeneratedKeys();

            if (resulset.next()) {
                autoincrementoJava = resulset.getInt(1);
            } else {
                throw new RuntimeException("No se genero el ID de autoincremento");
            }
            resulset.close();

            try {
                stmt_consul.close();
                conn.close();
                iscon = false;
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx.getMessage());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return autoincrementoJava;
    }

    public ResultSet Consulta(String strsql) {
        Statement stmt_consul = null;
        ResultSet rs = null;
        try {
            if (!iscon) {
                conn = ConectarBD();
            }
            stmt_consul = conn.createStatement();  //crear sentencia
            stmt_consul.executeQuery(strsql); //ejecuta la sentencia
            rs = stmt_consul.getResultSet();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return rs;
    }

    public ResultSet ConsultaPag(String strsql) {
        Statement stmt_consul = null;
        ResultSet rs = null;
        try {
            if (!iscon) {
                conn = ConectarBD();
            }
            stmt_consul = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  //crear sentencia
            stmt_consul.executeQuery(strsql);
            rs = stmt_consul.getResultSet();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return rs;
    }

    public void CloseBD() {
        try {
            if (stmt_consul != null) {
                stmt_consul.close();
            }
            conn.close();
            iscon = false;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
