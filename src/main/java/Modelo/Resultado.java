package Modelo;

public class Resultado {
    private final int numero;
    private final String color;
    private final TipoApuesta tipo;
    private final int monto;
    private final boolean acierto;
    private final int saldoFinal;

    public Resultado(int numero, String color, TipoApuesta tipo, int monto, boolean acierto, int saldoFinal) {
        this.numero = numero; this.color = color; this.tipo = tipo;
        this.monto = monto; this.acierto = acierto; this.saldoFinal = saldoFinal;
    }
    public int getNumero() { return numero; }
    public String getColor() { return color; }
    public TipoApuesta getTipo() { return tipo; }
    public int getMonto() { return monto; }
    public boolean isAcierto() { return acierto; }
    public int getSaldoFinal() { return saldoFinal; }
}