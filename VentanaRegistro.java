import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistro {

    public static final List USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegresar = new JButton("Regresar");

    public VentanaRegistro() {
        frame.setLayout(null);
        lblNombre.setBounds(30, 30, 80, 25);
        txtNombre.setBounds(110, 30, 150, 25);
        lblUsuario.setBounds(30, 70, 80, 25);
        txtUsuario.setBounds(110, 70, 150, 25);
        lblClave.setBounds(30, 120, 80, 25);
        txtClave.setBounds(110, 120, 150, 25);
        btnIngresar.setBounds(30, 200, 100, 30);
        btnRegresar.setBounds(30, 250, 100, 30);

        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        frame.add(btnRegresar);

        btnRegresar.addActionListener(actionEvenT -> IrSaludo());

    }

    public void mostrarVentana() {
        frame.setSize(300, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void IrSaludo() {
        this.frame.dispose();
        VentanaSaludo saludo = new VentanaSaludo();
        saludo.mostrarVentana();
    }

    private void IrLogin() {
        this.frame.dispose();
        VentanaLogin login = new VentanaLogin();
        login.mostrarVentana();
    }

    private void Registro() {
        String o = txtNombre.getText().trim();
        String p = txtUsuario.getText().trim();
        String q = txtClave.getText().trim();

        if (o.isEmpty() || p.isEmpty() || q.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ExisteUsuario(p)) {
            JOptionPane.showMessageDialog(frame, "El usuario ya existe. Intente con otro.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario NuevoUsuario = new Usuario(o,p,q);
        VentanaLogin.USUARIOS.add(NuevoUsuario);
        IrLogin();
    }

    private boolean ExisteUsuario(String Username) {
        for (Usuario u : VentanaLogin.USUARIOS) {
            if (u.getUsuario().equalsIgnoreCase(Username)) {
                return true;
            }
        }
        return false;
    }
}


