import javax.swing.*;

public class VentanaMenu {
    private final JFrame frame = new JFrame("Menú - Casino Black Cat");

    // Componentes de la izquierda (menú)
    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");
    private final JLabel lblAdmin = new JLabel("Administrador");

    // Componentes de la derecha (contenido)
    private final JLabel lblTitulo = new JLabel("RULETA — Casino Black Cat");
    private final JTextArea texto = new JTextArea();

    public VentanaMenu() {
        frame.setLayout(null);
        btnInicio.setBounds(30, 30, 120, 35);
        btnJugar.setBounds(30, 75, 120, 35);
        btnHistorial.setBounds(30, 120, 120, 35);
        btnSalir.setBounds(30, 165, 120, 35);
        lblAdmin.setBounds(30, 270, 120, 25);
        lblTitulo.setBounds(180, 25, 380, 30);

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
    }

    public void mostrarVentana() {
        frame.setSize(600, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}