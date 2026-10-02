import java.util.Random;
import java.util.Scanner;

public class Ruleta {

    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public static int girarRuleta() {
        return rng.nextInt(37);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) {
            return false;
        }
        if (tipo == 'P' && numero % 2 == 0) {
            return true;
        } else if (tipo == 'I' && numero % 2 != 0) {
            return true;
        } else if (tipo == 'R' && esRojo(numero)) {
            return true;
        } else if (tipo == 'N' && !esRojo(numero)) {
            return true;
        }

        return false;
    }

    public static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        } else {
            System.out.println("El historial de jugadas está lleno.");
        }
    }

    public static String mostrarResultado(int numero, char tipo, int monto, boolean acierto, int saldo) {
        String color = esRojo(numero) ? "Rojo" : "Negro";
        String estado = acierto ? "GANASTE" : "PERDISTE";

        return "Número " + numero + " (" + color + ") | Apuesta=" + tipo
                + " | Monto=$" + monto + " | " + estado + " | Saldo=" + saldo;
    }

    public static void mostrarEstadisticas() {
        if (historialSize == 0) {
            System.out.println("\nAún no se han jugado rondas. ¡Anímate a jugar!\n");
            return;
        }

        int montoTotalApostado = 0;
        int totalAciertos = 0;
        int gananciaNeta = 0;

        for (int i = 0; i < historialSize; i++) {
            int apuestaActual = historialApuestas[i];
            montoTotalApostado += apuestaActual;
            if (historialAciertos[i]) {
                totalAciertos++;
                gananciaNeta += apuestaActual;
            } else {
                gananciaNeta -= apuestaActual;
            }
        }

        double porcentajeAciertos = (totalAciertos * 100.0) / historialSize;

        System.out.println("\n=== ESTADÍSTICAS DEL JUGADOR ===");
        System.out.println("Rondas jugadas: " + historialSize);
        System.out.println("Monto total apostado: $" + montoTotalApostado);
        System.out.println("Cantidad total de aciertos: " + totalAciertos);
        System.out.println("Porcentaje de aciertos: " + porcentajeAciertos + "%");

        if (gananciaNeta >= 0) {
            System.out.println("Ganancia neta: +$" + gananciaNeta);
        } else {
            System.out.println("Pérdida neta: -$" + Math.abs(gananciaNeta));
        }
        System.out.println("================================\n");
    }
}