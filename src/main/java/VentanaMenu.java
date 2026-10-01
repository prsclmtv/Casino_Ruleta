import javax.swing.*;

//EN ventanLogin.login se pone el launcher hacia esta ventana

public class VentanaMenu {
    private final JFrame frame = new JFrame("Menú");
    private final JTextArea texto = new JTextArea();
    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaMenu() {
        frame.setLayout(null);
        texto.setBounds(200, 300, 200, 300);

        frame.add(texto);
        frame.add(btnInicio);
        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnSalir);
    }

    public void mostrarVentana() {
        frame.setSize(300, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
