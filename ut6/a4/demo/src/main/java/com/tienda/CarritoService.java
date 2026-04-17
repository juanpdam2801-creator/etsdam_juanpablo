package com.tienda;
/**
 * @author Jpsuaa
 * @version 1.0.0
 */
import java.util.List;
/**
 * Clase CarritoService
 */
public class CarritoService {
    /**
     * Funcion que calcula el subtotal de los productos del carrito
     * @param carrito
     * @return Sutotal del conjunto de los productos del carrito
     */
    public static double calcularSubtotal(List<Producto> carrito) {
        double subtotal = 0;
        for (Producto producto : carrito) {
            subtotal += producto.getPrecio()*producto.getCantidad();
        }
        return subtotal;
    }
    /**
     * Funcion que aplica un decuento a los poductos del carrito
     * @param subtotal
     * @param descuento
     * @return Calculo del descuento sobre el carrito
     */
    public static double aplicarDescuento(double subtotal, double descuento) {
        if(descuento > 100 || descuento < 0) {
            throw new IllegalArgumentException("El descuento es invalido.");
        }
        return subtotal-(subtotal*descuento/100);
    }
    /**
     * Funcion que calcula el costo del envio del producto
     * @param subtotal
     * @return El costo final del envio
     */
    public static double calcularEnvio(double subtotal) {
        if (subtotal >= 100) {
            return 0;
        } else {
            return 5;
        }
    }
    /**
     * Funcion que calcula el total monetario del carrito
     * @param carrito
     * @param descuento
     * @return El coste total de todos los items carrito
     */
    public static double calcularTotal(List<Producto> carrito, double descuento) {
        double subtotal = calcularSubtotal(carrito);
        double conDescuento = aplicarDescuento(subtotal, descuento);
        double envio = calcularEnvio(subtotal);
        return conDescuento + envio;
    }
}
