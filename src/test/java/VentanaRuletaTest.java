import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VentanaRuletaTest {
    @Test
    void metodoprobarventana() throws InterruptedException {
        VentanaRuleta menu = new VentanaRuleta();
        menu.mostrarVentana();
        Thread.sleep(10000);
    }
}