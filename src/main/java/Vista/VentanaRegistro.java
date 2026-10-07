package Vista;

import Controlador.SessionController;

import javax.swing.*;

public class VentanaRegistro {
    SessionController session;
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegresar = new JButton("Regresar");

    public VentanaRegistro(SessionController SessionController) {
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
        btnIngresar.addActionListener(actionEvent -> Registro());

    }

    public void mostrarVentana() {
        frame.setSize(300, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void IrSaludo() {
        this.frame.dispose();
        VentanaSaludo saludo = new VentanaSaludo(session);
        saludo.mostrarVentana();
    }

    private void IrLogin() {
        this.frame.dispose();
        VentanaLogin login = new VentanaLogin(session);
        login.mostrarVentana();
    }

    private void Registro() {
        String nombre  = txtNombre.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String clave   = new String(txtClave.getPassword()).trim();

        if (nombre.isEmpty() || usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (session.existeUsuario(usuario)) {
            JOptionPane.showMessageDialog(frame, "El usuario ya existe. Intente con otro.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        session.registrarUsuario(usuario, clave, nombre);
        IrLogin();
    }

    }



