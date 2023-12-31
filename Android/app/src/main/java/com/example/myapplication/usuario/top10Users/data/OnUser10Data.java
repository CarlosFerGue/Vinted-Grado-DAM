package com.example.myapplication.usuario.top10Users.data;

public class OnUser10Data {

    private int id;
    private String nombre, email, contrasena, apellido1, apellido2, user;

    public OnUser10Data(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public OnUser10Data() {

    }

    public OnUser10Data(int id, String nombre, String email, String contrasena, String apellido1, String apellido2, String user) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.user = user;
    }


    @Override
    public String toString(){
        return "User10Activity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email=" + email +
                ", contrasena='" + contrasena + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
