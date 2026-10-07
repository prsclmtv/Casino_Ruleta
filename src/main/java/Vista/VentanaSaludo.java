package Vista;
import Controlador.SessionController;
import Controlador.RuletaController;
import javax.swing.*;


public class VentanaSaludo {

    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JLabel lbEleccion = new JLabel("Elija si iniciar sesión o registrarse:");
    private final JButton btnIniciar = new JButton("Iniciar sesión");
    private final JButton btnRegistrar = new JButton("Regisrarse");
    private final SessionController session;
    private final RuletaController ruletaControlador;

    public VentanaSaludo(SessionController session, RuletaController ruletaControlador) {
        this.session = session;
        this.ruletaControlador = ruletaControlador;
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
        VentanaLogin login = new VentanaLogin(session,ruletaControlador);
        login.mostrarVentana();
    }

    private void IrRegistro() {
        this.frame.dispose();
        VentanaRegistro registro = new VentanaRegistro(session, ruletaControlador);
        registro.mostrarVentana();
    }
}

