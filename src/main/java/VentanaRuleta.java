import javax.swing.*;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Ruleta - Casino");

    private final JLabel lblTipoApuesta = new JLabel("Tipo de apuesta:");
    private final JLabel lblColor = new JLabel("Seleccione color:");
    private final JLabel lblParidad = new JLabel("Seleccione paridad:");
    private final JLabel lblMonto = new JLabel("Monto:");

    private final JComboBox<String> comboTipoApuesta = new JComboBox<>(new String[]{"Color", "Paridad"});
    private final JComboBox<String> comboColor = new JComboBox<>(new String[]{"Rojo", "Negro"});
    private final JComboBox<String> comboParidad = new JComboBox<>(new String[]{"Par", "Impar"});

    private final JSpinner spinnerMonto = new JSpinner(new SpinnerNumberModel(100, 1, 10000, 10));
    private final JButton btnGirar = new JButton("Girar");
    private final JTextField txtSaldo = new JTextField("Saldo: 1100");

    private final JLabel lblResultado = new JLabel("");
    private final JSeparator separador = new JSeparator();

    public VentanaRuleta() {
        frame.setLayout(null);

        lblTipoApuesta.setBounds(30, 20, 140, 25);
        comboTipoApuesta.setBounds(170, 20, 350, 28);


        lblColor.setBounds(30, 60, 140, 25);
        comboColor.setBounds(170, 60, 350, 28);

        lblParidad.setBounds(30, 100, 140, 25);
        comboParidad.setBounds(170, 100, 350, 28);
        comboParidad.setEnabled(false);

        lblMonto.setBounds(30, 140, 140, 25);
        spinnerMonto.setBounds(170, 140, 110, 28);
        btnGirar.setBounds(290, 140, 80, 28);

        txtSaldo.setBounds(380, 140, 140, 28);
        txtSaldo.setEditable(false);

        lblResultado.setBounds(30, 185, 490, 25);

        separador.setBounds(20, 300, 520, 2);

        frame.add(lblTipoApuesta);
        frame.add(comboTipoApuesta);

        frame.add(lblColor);
        frame.add(comboColor);

        frame.add(lblParidad);
        frame.add(comboParidad);

        frame.add(lblMonto);
        frame.add(spinnerMonto);
        frame.add(btnGirar);
        frame.add(txtSaldo);

        frame.add(lblResultado);
        frame.add(separador);


    }

    public void mostrarVentana() {
        frame.setSize(570, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setResultado(String texto) {
        lblResultado.setText(texto);
    }
}