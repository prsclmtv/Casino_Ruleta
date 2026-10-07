package Launcher;

import Controlador.SessionController;
import Vista.VentanaSaludo;

public class Launcher {
    public static void main(String[] args) {
        SessionController session = new SessionController();
        new VentanaSaludo(session).mostrarVentana();
    }
}