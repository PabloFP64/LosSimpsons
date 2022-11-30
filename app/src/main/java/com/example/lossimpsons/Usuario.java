package com.example.lossimpsons;

public class Usuario {

    private String nombre;
    private String usuario;
    private String eMail;
    private String contrasena;

    public Usuario(String nombre, String usuario, String eMail, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.eMail = eMail;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
