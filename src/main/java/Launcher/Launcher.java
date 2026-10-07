package Launcher;

import Controlador.SessionController;
import Controlador.RuletaController;
import Vista.VentanaSaludo;

public class Launcher {
    public static void main(String[] args) {
        SessionController session = new SessionController();
        RuletaController controlador = new RuletaController(session);
        new VentanaSaludo(session,controlador).mostrarVentana();
    }
}