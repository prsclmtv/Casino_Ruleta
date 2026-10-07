package Vista;

import javax.swing.*;

import Controlador.RuletaController;
import Modelo.TipoApuesta;

public class VentanaRuleta {


    private final JFrame frame = new JFrame("Ruleta - Casino");

    private final JLabel lblTipoApuesta = new JLabel("Tipo de apuesta:");
    private final JLabel lblColor = new JLabel("Seleccione color:");
    private final JLabel lblParidad = new JLabel("Seleccione paridad:");
    private final JLabel lblMonto = new JLabel("Monto:");

    private final JComboBox<TipoApuesta> comboTipoApuesta = new JComboBox<>(TipoApuesta.values());

    private final JSpinner spinnerMonto = new JSpinner(new SpinnerNumberModel(100, 1, 10000, 10));
    private final JButton btnGirar = new JButton("Girar");
    private final JTextField txtSaldo = new JTextField("");


    private final JLabel lblResultado = new JLabel("");
    private final JSeparator separador = new JSeparator();

    public VentanaRuleta(RuletaController controlador) {
        frame.setLayout(null);

        lblTipoApuesta.setBounds(30, 20, 140, 25);
        comboTipoApuesta.setBounds(170, 20, 350, 28);

        lblColor.setBounds(30, 60, 140, 25);
        lblParidad.setBounds(30, 100, 140, 25);

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
        frame.add(lblParidad);


        frame.add(lblMonto);
        frame.add(spinnerMonto);
        frame.add(btnGirar);
        frame.add(txtSaldo);

        frame.add(lblResultado);
        frame.add(separador);

        btnGirar.addActionListener(e -> {
            TipoApuesta tipo = (TipoApuesta) comboTipoApuesta.getSelectedItem();
            int monto = (int) spinnerMonto.getValue();
            try {
                lblResultado.setText(controlador.apostar(tipo, monto));
                txtSaldo.setText("Saldo: " + controlador.getSaldo());
            } catch (IllegalArgumentException ex) {
                lblResultado.setText(ex.getMessage());
            }
        });

        comboTipoApuesta.addActionListener(e -> {
            boolean esColor = comboTipoApuesta.getSelectedItem().equals("Color");
        });

        txtSaldo.setText("Saldo: " + controlador.getSaldo());
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