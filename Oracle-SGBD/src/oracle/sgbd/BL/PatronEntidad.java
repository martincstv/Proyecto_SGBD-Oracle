/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oracle.sgbd.BL;

/**
 *
 * @author Martin
 */
public class PatronEntidad {

    protected int ID;
    protected String Cedula;
    protected String Nombre;
    protected String Apellido;
    protected String Correo;
    protected String Telefono;
    protected float Sueldo;

    public PatronEntidad() {
    }

    public PatronEntidad(int ID, String Cedula, String Nombre, String Apellido, String Correo, String Telefono, float Sueldo) {
        this.ID = ID;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Sueldo = Sueldo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }
}
