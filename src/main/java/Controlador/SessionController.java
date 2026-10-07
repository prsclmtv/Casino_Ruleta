package Controlador;
import Modelo.*;
import java.util.*;

public class SessionController {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<String, Ruleta> ruletas = new HashMap<>();
    private Usuario usuarioActual;
    private Ruleta ruletaActual;

    public boolean existeUsuario(String username) {
        for (Usuario u : usuarios)
            if (u.getUsuario().equalsIgnoreCase(username)) return true;
        return false;
    }

    public void registrarUsuario(String username, String clave, String nombre) {
        if (username.isBlank() || clave.isBlank() || nombre.isBlank())
            throw new IllegalArgumentException("Datos requeridos");
        if (existeUsuario(username))
            throw new IllegalArgumentException("El usuario ya existe");
        usuarios.add(new Usuario(username, clave, nombre));
        ruletas.put(username.toLowerCase(), new Ruleta(1000));   // saldo inicial
    }

    public boolean iniciarSesion(String username, String clave) {
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(username, clave)) {
                usuarioActual = u;
                ruletaActual = ruletas.get(u.getUsuario().toLowerCase());
                return true;
            }
        }
        return false;
    }

    public String getNombreUsuario() { return usuarioActual == null ? "" : usuarioActual.getNombre(); }
    public String getUsername() { return usuarioActual == null ? "" : usuarioActual.getUsuario(); }
    public void cambiarNombre(String nuevo) { usuarioActual.setNombre(nuevo); }
    public Ruleta getRuleta() { return ruletaActual; }
    public void cerrarSesion() { usuarioActual = null; ruletaActual = null; }
}