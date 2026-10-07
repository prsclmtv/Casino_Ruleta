import Vista.VentanaMenu;
import org.junit.jupiter.api.Test;

class VentanaMenuTest {
    @Test
    void metodoprobarventana() throws InterruptedException {
        VentanaMenu menu = new VentanaMenu();
        menu.mostrarVentana();
        Thread.sleep(10000);
    }

}