import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.BorderFactory;

public class VentanaLogin {

    public static final List <Usuario> USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegresar = new JButton("Regresar");


    public VentanaLogin() {
        frame.setLayout(null);
        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(110, 30, 150, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(110, 70, 150, 25);
        btnIngresar.setBounds(30, 120, 100, 30);
        btnRegresar.setBounds(30, 170, 100, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        frame.add(btnRegresar);

        btnRegresar.addActionListener(actionEvenT-> IrSaludo());

    }

    public void mostrarVentana() {
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void IrSaludo() {
        this.frame.dispose();
        VentanaSaludo saludo = new VentanaSaludo();
        saludo.mostrarVentana();
    }

    private void login() {
        String u = txtUsuario.getText().trim();
        String p = txtClave.getText().trim();

        if (p.isEmpty() || u.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String Nombre = validarCredenciales(u,p);

        if (Nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "El suario y la contraseña no coinciden, intente nuevamente", "Error de ingeso", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private String validarCredenciales(String u, String p) {
        for (Usuario user : USUARIOS) {
            if (user.validarCredenciales(u,p)) {
                return(user.getNombre());
            }
        }
        return "";
    }
}

