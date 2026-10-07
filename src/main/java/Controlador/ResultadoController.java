package Controlador;
import Modelo.Resultado;
import java.util.List;

public class ResultadoController {

    public String formatear(Resultado r) {
        return "Número " + r.getNumero() + " (" + r.getColor() + ") | Apuesta=" + r.getTipo()
                + " | Monto=$" + r.getMonto() + " | " + (r.isAcierto() ? "GANASTE" : "PERDISTE")
                + " | Saldo=" + r.getSaldoFinal();
    }

    public String estadisticas(List<Resultado> historial) {
        if (historial.isEmpty()) return "Aún no se han jugado rondas. ¡Anímate a jugar!";

        int apostado = 0, aciertos = 0, neta = 0;
        for (Resultado r : historial) {
            apostado += r.getMonto();
            if (r.isAcierto()) { aciertos++; neta += r.getMonto(); }
            else neta -= r.getMonto();
        }
        double porcentaje = aciertos * 100.0 / historial.size();

        return "=== ESTADÍSTICAS ===\n"
                + "Rondas jugadas: " + historial.size() + "\n"
                + "Monto total apostado: $" + apostado + "\n"
                + "Aciertos: " + aciertos + "\n"
                + "Porcentaje de aciertos: " + String.format("%.1f", porcentaje) + "%\n"
                + (neta >= 0 ? "Ganancia neta: +$" + neta : "Pérdida neta: -$" + Math.abs(neta));
    }
}