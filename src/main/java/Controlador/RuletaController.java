package Controlador;

import Modelo.*;

public class RuletaController {
    private final SessionController session;
    private final ResultadoController resultados = new ResultadoController();

    public RuletaController(SessionController session) { this.session = session; }

    public int getSaldo() { return session.getRuleta().getSaldo(); }

    public String apostar(TipoApuesta tipo, int monto) {
        Resultado r = session.getRuleta().apostar(tipo, monto);
        return resultados.formatear(r);
    }

    public void depositar(int monto) { session.getRuleta().depositar(monto); }

    public String getEstadisticas() {
        return resultados.estadisticas(session.getRuleta().getHistorial());
    }
}