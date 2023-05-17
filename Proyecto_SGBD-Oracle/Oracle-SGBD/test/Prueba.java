/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import oracle.sgbd.DAL.Conexion;
/**
 *
 * @author lucer
 */
public class Prueba {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        
        //con.ejecutarSentenciaSQL("CREATE USAR ISAAC IDENTIFIED BY \"1234\"");
        //con.ejecutarSentenciaSQL("GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO ISAAC");
        con.ejecutarSentenciaSQL("CREATE TABLE PRUEBA("
                + "ID VARCHAR(5) PRIMARY KEY,"
                + "NOMBRE VARCHAR(10),"
                + "APELLIDO VARCHAR(10));");
    }
}
