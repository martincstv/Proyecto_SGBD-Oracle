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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DatabaseMetaData;

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
        user = "ISAAC";
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

    public Conexion(String usuario, String contraseña) {
        connection = null;
        url = "jdbc:oracle:thin:@localhost:1521:XE";
        user = usuario;
        password = contraseña;
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

    public String[] obtenerNombresUsuarios() {
        // Crea una lista para almacenar los nombres de usuarios
        List<String> nombresUsuarios = new ArrayList<>();

        try {
            // Crea una declaración SQL
            Statement statement = connection.createStatement();

            // Ejecuta una consulta para obtener los nombres de los usuarios
            ResultSet resultSet = statement.executeQuery("SELECT username FROM all_users");

            // Recorre los resultados y agrega los nombres de usuarios a la lista
            while (resultSet.next()) {
                String nombreUsuario = resultSet.getString("username");
                nombresUsuarios.add(nombreUsuario);
            }

            // Cierra los recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convierte la lista de nombres de usuarios a un arreglo de cadenas
        String[] arrayNombresUsuarios = nombresUsuarios.toArray(new String[0]);

        // Devuelve el arreglo de nombres de usuarios
        return arrayNombresUsuarios;
    }
    
    public ResultSet ejecutarConsulta(String consulta) {
        ResultSet resultSet = null;
        
        try {
            // Crea una sentencia (Statement) para ejecutar la consulta
            Statement statement = connection.createStatement();
            
            // Ejecuta la consulta y obtiene el resultado en un ResultSet
            resultSet = statement.executeQuery(consulta);
            
            // No cierres la conexión aquí si planeas utilizar el ResultSet fuera de este método
            // La conexión y el Statement se cerrarán en el código que utilice el ResultSet
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultSet;
    }
    public List<Object[]> ejecutarConsultaSelect(String consulta) {
        List<Object[]> resultado = new ArrayList<>();
        try {

            // Crea una sentencia preparada (PreparedStatement) para ejecutar la consulta
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecuta la consulta y obtiene el resultado en un ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Obtiene los metadatos del ResultSet para obtener el número de columnas
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Recorre los resultados del ResultSet
            while (resultSet.next()) {
                // Crea un array de objetos para almacenar los valores de las columnas
                Object[] fila = new Object[columnCount];
                
                // Obtiene los valores de cada columna y los agrega al array
                for (int i = 1; i <= columnCount; i++) {
                    fila[i - 1] = resultSet.getObject(i);
                }
                
                // Agrega la fila al resultado
                resultado.add(fila);
            }

            // Cierra el ResultSet, el PreparedStatement y la conexión
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
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

    public String[] obtenerTablas() {
        // Crea una lista para almacenar los nombres de las tablas
        List<String> nombresTablas = new ArrayList<>();

        try {
            // Obtiene los metadatos de la base de datos
            DatabaseMetaData metaData = connection.getMetaData();

            // Obtén las tablas de la base de datos
            ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});

            // Recorre los resultados y agrega los nombres de las tablas a la lista
            while (resultSet.next()) {
                String nombreTabla = resultSet.getString("TABLE_NAME");
                nombresTablas.add(nombreTabla);
            }

            // Cierra los recursos
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convierte la lista de nombres de tablas a un arreglo de cadenas
        String[] arrayNombresTablas = nombresTablas.toArray(new String[0]);

        // Devuelve el arreglo de nombres de tablas
        return arrayNombresTablas;
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
