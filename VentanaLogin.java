import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.BorderFactory;

public class VentanaLogin {

    public static final List USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");

    public VentanaLogin() {
        frame.setLayout(null);
        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(110, 30, 150, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(110, 70, 150, 25);
        btnIngresar.setBounds(30, 120, 100, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);


    }

    public void mostrarVentana() {
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /**
     * Gestiona el inicio de sesión al presionar el botón.
     * Debe validar las credenciales ingresadas y abrir la siguiente
     * ventana o mostrar un mensaje de error.
     */
    private void login() {
// TODO: Implementar la lógica de inicio de sesión
    }
    /**
     * Valida las credenciales ingresadas utilizando la lista de usuarios.
     *
     * @param u nombre de usuario ingresado
     * @param p contraseña ingresada
     * @return el nombre del usuario si las credenciales son válidas o una cadena vacía
    si no existe una coincidencia
     */
    private String validarCredenciales(String u, String p) {
// TODO: Recorrer la lista y validar las credenciales
        return "";
    }

    private void abrirRegistro() {
// TODO: Cerrar la ventana actual y abrir la ventana de registro
    }
}

