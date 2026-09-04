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
        leerTipoApuesta(in);
    }

    public static void mostrarMenu() {
        System.out.println("Menú Ruleta");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Ver estadísticas");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static int leerOpcion(Scanner in) {

        return 0;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {

    }

    public static void iniciarRonda(Scanner in) {

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

        return 0;
    }

    public static boolean evaluarResultado(int numero, char tipo) {

        return false;
    }

    public static boolean esRojo(int n) {

        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {

    }

    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {

    }

    public static void mostrarEstadisticas() {

    }
}