import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistro {

    public static final List USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblNombre = new JLabel("Usuario:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegresar = new JButton("Regresar");

    public VentanaRegistro() {
        frame.setLayout(null);

        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(110, 30, 150, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(110, 70, 150, 25);
        btnIngresar.setBounds(30, 120, 100, 30);
        btnRegresar.setBounds(30, 170, 100, 30);

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
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void IrSaludo() {
        this.frame.dispose();
        VentanaSaludo saludo = new VentanaSaludo();
        saludo.mostrarVentana();
    }

    private void registro() {

    }
}


