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

    public static boolean ExisteUsuario(String Username) {
        for (Usuario u : VentanaLogin.USUARIOS) {
            if (u.getUsuario().equalsIgnoreCase(Username)) {
                return true;
            }
        }
        return false;
}
}
