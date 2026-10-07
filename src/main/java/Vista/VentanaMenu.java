package Vista;

import javax.swing.*;
import Controlador.SessionController;
import Controlador.RuletaController;

public class VentanaMenu {
    private final JFrame frame = new JFrame("Menú - Casino Black Cat");

    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");
    private final JLabel lblAdmin = new JLabel("");

    private final JLabel lblTitulo = new JLabel("RULETA — Casino Black Cat");
    private final JTextArea texto = new JTextArea();

    private final RuletaController ruletaController;
    private final JLabel lblSaldo = new JLabel();

    public VentanaMenu(SessionController session, RuletaController ruletaController) {
        this.ruletaController = ruletaController;
        frame.setLayout(null);
        btnInicio.setBounds(30, 30, 120, 35);
        btnJugar.setBounds(30, 75, 120, 35);
        btnHistorial.setBounds(30, 120, 120, 35);
        btnSalir.setBounds(30, 165, 120, 35);
        lblAdmin.setBounds(30, 270, 120, 25);
        lblTitulo.setBounds(180, 25, 380, 30);
        lblSaldo.setBounds(180, 270, 200, 25);

        lblAdmin.setText(session.getNombreUsuario());
        actualizarSaldo();

        texto.setBounds(180, 65, 380, 200);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setText("Bienvenido/a al menú principal.\n" +
                "A la izquierda tienes:\n" +
                "• Jugar: abre la ventana de juego (se implementará aparte).\n" +
                "• Historial: abre la ventana de historial (se implementará aparte).\n" +
                "• Salir: cierra sesión y vuelve al login.");


        frame.add(btnInicio);
        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnSalir);
        frame.add(lblAdmin);
        frame.add(lblTitulo);
        frame.add(texto);
        frame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override public void windowGainedFocus(java.awt.event.WindowEvent e) { actualizarSaldo(); }
        });

        btnJugar.addActionListener(e -> new VentanaRuleta(ruletaController).mostrarVentana());
        btnHistorial.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, ruletaController.getEstadisticas(), "Historial", JOptionPane.INFORMATION_MESSAGE));
        btnSalir.addActionListener(e -> {
            session.cerrarSesion();
            frame.dispose();
            new VentanaLogin(session,ruletaController).mostrarVentana();
        });
    }

    public void mostrarVentana() {
        frame.setSize(600, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void actualizarSaldo() {
        lblSaldo.setText("Saldo: $" + ruletaController.getSaldo());
    }
}