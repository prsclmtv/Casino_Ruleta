import java.util.Random;
import java.util.Scanner;

public class Casino_Ruleta {

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

    public static void main(String[] args) {

        menu();
        
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        mostrarMenu();
        int opcion = leerOpcion(in);
        ejecutarOpcion(opcion,in);
    }

    public static void mostrarMenu() {
        System.out.println("Menú Ruleta");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Ver estadísticas");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static int leerOpcion(Scanner in) {
        int opcion = 0;
        if (in.hasNextInt()) {
            opcion = in.nextInt();
        } else {
            in.next();
        }
        return opcion;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        switch (opcion) {
            case 1:
                iniciarRonda(in);
                break;
            case 2:
                mostrarEstadisticas();
                break;
            case 3:
                System.out.println("Saliendo de la Ruleta. ¡Gracias por jugar!");
                break;
            default:
                System.out.println("Inválido, intente nuevamente.\n");
                break;
        }
    }

    public static void iniciarRonda(Scanner in) {
        char tipo =  leerTipoApuesta(in);
        System.out.print("Ingrese el monto a apostar: ");
        int monto = in.nextInt();
        int resultado_numero = girarRuleta();
        boolean resultado_gano = evaluarResultado(resultado_numero,tipo);
        registrarResultado(resultado_numero, monto, resultado_gano);
        mostrarResultado(resultado_numero,tipo,monto,resultado_gano);

    }

    public static char leerTipoApuesta(Scanner in) {
        int opcion;
        char tipo = ' ';
        do {
            System.out.println("Seleccione el tipo de apuesta:");
            System.out.println("1. Rojo");
            System.out.println("2. Negro");
            System.out.println("3. Par");
            System.out.println("4. Impar");
            opcion = in.nextInt();
            if (opcion == 1) {
                tipo = 'R';
            } else if (opcion == 2) {
                tipo = 'N';
            } else if (opcion == 3) {
                tipo = 'P';
            } else if (opcion == 4) {
                tipo = 'I';
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion < 1 || opcion > 4);
        return tipo;
    }

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

    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {
        System.out.println("RESULTADO");
        System.out.println("El número es: " + numero);
        System.out.println("Apostaste al tipo: '" + tipo + "' con un monto de $" + monto);

        if (acierto) {
            System.out.println("Has ganado");
        } else {
            System.out.println("Has perdido");
        }
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