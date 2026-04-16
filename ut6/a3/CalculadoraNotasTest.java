package calculadora;
/**
 * @author Jpsuaa
 * @version 1.0.0
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
/**
 * Clase con las pruebas/test para probar la seguridad del codigo
 */
public class CalculadoraNotasTest {
    /**
     * Este test comprueba que el calculo de la nota media es correcto
     */
    @Test
    void testMediaSimple() {
        assertEquals(7.0, CalculadoraNotas.calcularMedia(new int[]{6, 7, 8}));
    }
    /**
     * Este test comprueba que el calculo de la nota media es correcto con decimales
     */
    @Test
    void testMediaDecimal() {
        assertEquals(8.5, CalculadoraNotas.calcularMedia(new int[]{10, 9, 8, 7}));
    }
    /**
     * Este test salta cuando se detecta que el calculo de la nota media es vacio
     */
    @Test
    void testListaVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[]{});
        });
    }
    /**
     * Este test salta cuando se detecta que el calculo de la nota media es nulo
     */
    @Test
    void testNotaFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[]{5, 12, 8});
        });
    }
}
