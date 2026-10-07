package Modelo;

import Vista.VentanaLogin;

public class Usuario {
    private String username;
    private String password;
    private String nombre;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }
    public String getNombre() {
        return nombre;
    }
    public String getUsuario() { return username;}

    public Usuario() { this("invitado", "", "Invitado"); }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }
}

