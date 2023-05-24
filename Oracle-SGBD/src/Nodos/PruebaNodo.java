/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

import oracle.sgbd.DAL.Conexion;
import java.sql.ResultSet;
/**
 *
 * @author lucer
 */
public class PruebaNodo {

    public static void MetodoPrueba(String tabla) {
        Conexion con = new Conexion();
        con.ejecutarSentenciaSQL("SELECT * FROM " + tabla);
    }

    public static void MetodoInsert(String tabla, String datos) {
        Conexion con = new Conexion();
        con.ejecutarSentenciaSQL("INSERT INTO " + tabla + " VALUES(" + datos + ")");
    }
    public static void MetodoSQLQuery(String sentencia) {
        Conexion con = new Conexion();
        con.ejecutarSentenciaSQL(sentencia);
    }
    public static String MetodoIniciarBD(String usuario, String contraseña) {
        Conexion con = new Conexion();
        try {
            //con.Conexion(usuario, contraseña);
        } catch (Exception e) {
            return "Error";
        }
        return "";
    }
    public static String[] NombreUsuarios(){
        Conexion con = new Conexion();        
        String[] nombresUsuarios =  con.obtenerNombresUsuarios();
        return nombresUsuarios;
    }
    public static String[] NombreTablas(){
        Conexion con = new Conexion();        
        String[] nombreTablas =  con.obtenerTablas();
        return nombreTablas;
    }
    public static ResultSet Select(String consultaa){
        Conexion con = new Conexion();
        ResultSet resultset = con.consultarRegistros(consultaa);
        return resultset;
    }
}
