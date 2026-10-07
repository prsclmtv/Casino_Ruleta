package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {
    private static final int[] NUMEROS_ROJOS = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    private final Random rng = new Random();
    private final List<Resultado> historial = new ArrayList<>();
    private int saldo;

    public Ruleta(int saldoInicial) { this.saldo = saldoInicial; }
    public Ruleta() { this(0); }

    public int getSaldo() { return saldo; }

    public void depositar(int monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a 0");
        saldo += monto;
    }

    public Resultado apostar(TipoApuesta tipo, int monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a 0");
        if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente para esa apuesta.");

        int numero = rng.nextInt(37);
        boolean acierto = evaluarResultado(numero, tipo);
        saldo += acierto ? monto : -monto;

        Resultado r = new Resultado(numero, colorDe(numero), tipo, monto, acierto, saldo);
        historial.add(r);
        return r;
    }

    public boolean evaluarResultado(int numero, TipoApuesta tipo) {
        if (numero == 0) return false;
        return switch (tipo) {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
    }

    private boolean esRojo(int n) {
        for (int r : NUMEROS_ROJOS) if (r == n) return true;
        return false;
    }

    private String colorDe(int n) {
        return n == 0 ? "Verde" : (esRojo(n) ? "Rojo" : "Negro");
    }

    public List<Resultado> getHistorial() { return new ArrayList<>(historial); }
}