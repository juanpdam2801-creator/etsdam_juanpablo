
/**
 * @author AlejandroDonGar
 * @version 1.0.0
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.java.CarritoService;
import com.java.Producto;
/**
 * Clase CarritoTest que usamos para comprobar que el programa se comporte como esperado 
 */
public class CarritoTest {
    /**
     * Este test comprueba que el subtotal de varios productos es correctos
     */
    @Test
    void testSubtotalVariosProductos() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 30, 2),
            new Producto("raton", 10, 1)
        );

        assertEquals(70, CarritoService.calcularSubtotal(carrito));
    }
    /**
     * Este test combrueba que el subtotal de un producto es correcto
     */
    @Test
    void testSubtotalUnProducto() {
        List<Producto> carrito = List.of(
            new Producto("monitor", 100, 1)
        );

        assertEquals(100, CarritoService.calcularSubtotal(carrito));
    }
    /**
     * Este test comprueba que pasa cuando generamos un subtotal de un carrito vacio
     */
    @Test
    void testSubtotalCarritoVacio() {
        List<Producto> carrito = List.of();

        assertEquals(0, CarritoService.calcularSubtotal(carrito));
    }
    /**
     * Este test comprueba que el descuento en base al subtotal es correcto
     */
    @Test
    void testDescuento0() {
        assertEquals(100, CarritoService.aplicarDescuento(100, 0));
    }
    /**
     * Este test comprueba que el descuento en base al subtotal es valido
     */
    @Test
    void testDescuentoValido() {
        assertEquals(90, CarritoService.aplicarDescuento(100, 10));
    }

    @Test
    void testDescuento100() {
        assertEquals(0, CarritoService.aplicarDescuento(100, 100));
    }
    /**
     * Este test comprueba si un descuento es negativo
     */
    @Test
    void testDescuentoInvalidoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarritoService.aplicarDescuento(100, -5);
        });
    }
    /**
     * Este test comprueba si un test supera al subtotal del propio producto
     */
    @Test
    void testDescuentoInvalidoMayor100() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarritoService.aplicarDescuento(100, 120);
        });
    }
    /**
     * Este test comprueba si el envia es correcto para un pedido de menor de 100 euros
     */
    @Test
    void testEnvioMenor100() {
        assertEquals(5, CarritoService.calcularEnvio(50));
    }
    /**
     * Este test comprueba si el envia es correcto para un pedido igual o mayor de 100 euros
     */
    @Test
    void testEnvioMayorIgual100() {
        assertEquals(0, CarritoService.calcularEnvio(100));
    }
    /**
     * Este test compreuab el subtotal del producto sin descuento
     */
    @Test
    void testTotalSinDescuento() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 50, 1)
        );

        assertEquals(55, CarritoService.calcularTotal(carrito, 0));
    }
    /**
     * Este test comprueba que el subtotal final es correcto tras aplicar un descuento
     */
    @Test
    void testTotalConDescuento() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 100, 1)
        );

        assertEquals(90, CarritoService.calcularTotal(carrito, 10));
    }
    /**
     * Este test comprueba que el subtotal es correcto tras aplicar un envio gratis
     */
    @Test
    void testTotalEnvioGratis() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 120, 1)
        );

        assertEquals(120, CarritoService.calcularTotal(carrito, 0));
    }
}