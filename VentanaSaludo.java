import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaSaludo {

    public static final List USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JLabel lbEleccion = new JLabel("Elija si iniciar sesión o registrarse:");
    private final JButton btnIniciar = new JButton("Iniciar sesión");
    private final JButton btnRegistrar = new JButton("Regisrarse");

    public VentanaSaludo() {
        frame.setLayout(null);
        lbEleccion.setBounds(30, 30, 400, 25);
        btnRegistrar.setBounds(30, 120, 100, 30);
        btnIniciar.setBounds(170, 120, 120, 30);
        frame.add(lbEleccion);
        frame.add(btnIniciar);
        frame.add(btnRegistrar);

        btnIniciar.addActionListener(e -> IrLogin());
        btnRegistrar.addActionListener(e -> IrRegistro());
    }

    public void mostrarVentana() {
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void IrLogin() {
        this.frame.dispose();
        VentanaLogin login = new VentanaLogin();
        login.mostrarVentana();
    }

    private void IrRegistro() {
        this.frame.dispose();
        VentanaRegistro registro = new VentanaRegistro();
        registro.mostrarVentana();
    }
}

