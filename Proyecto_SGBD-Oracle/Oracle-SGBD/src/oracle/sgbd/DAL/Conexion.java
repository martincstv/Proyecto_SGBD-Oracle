/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oracle.sgbd.DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Martin
 */
public class Conexion {
    private String url, user, password;
    public Connection connection;
    protected PreparedStatement preStmt;
    protected Statement stmt;
    public ResultSet rst;
    private String errString;

    public Conexion() {
        connection = null;
        url = "jdbc:oracle:thin:@localhost:1521:XE";
        user = "SYSTEM";
        password = "1234";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Conexión establecida...");
        } catch (SQLException e) {
            errString = "Error mientras se conectaba a la BD: ";
            System.out.println(errString + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean ejecutarSentenciaSQL(String sentenciaSQL) {
        try {
            preStmt = connection.prepareStatement(sentenciaSQL);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public ResultSet consultarRegistros(String sentenciaSQL) {
        try {
            preStmt = connection.prepareStatement(sentenciaSQL);
            rst = preStmt.executeQuery();
            return rst;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}

