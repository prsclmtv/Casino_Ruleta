import Vista.VentanaRuleta;
import org.junit.jupiter.api.Test;

class VentanaRuletaTest {
    VentanaRuleta ruleta = new VentanaRuleta();
    @Test
    void metodoprobarventana() throws InterruptedException {
        ruleta.mostrarVentana();
        Thread.sleep(50000);
    }

    void metodoprobarsetResultado() throws InterruptedException {

    }
}