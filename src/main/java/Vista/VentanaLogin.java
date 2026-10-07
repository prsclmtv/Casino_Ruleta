package Vista;

import javax.swing.*;
import Controlador.SessionController;
import Controlador.RuletaController;

public class VentanaLogin {


    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegresar = new JButton("Regresar");
    private final SessionController session;
    private final RuletaController controlador;

    public VentanaLogin(SessionController SessionController, RuletaController controlador) {
        this.session = SessionController;
        this.controlador = controlador;
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
        btnIngresar.addActionListener(actionEvenT-> login());

    }

    public void mostrarVentana() {
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void IrSaludo() {
        this.frame.dispose();
        VentanaSaludo saludo = new VentanaSaludo(session, controlador);
        saludo.mostrarVentana();
    }

    private void login() {
        String u = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();

        if (!session.iniciarSesion(u, clave)) {
            JOptionPane.showMessageDialog(frame, "El usuario y la contraseña no coinciden, intente nuevamente", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        frame.dispose();
        new VentanaMenu(session,controlador).mostrarVentana();
    }

}

