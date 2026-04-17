package com.tienda;
/**
 * @author Jpsuaa
 * @version 1.0.0
 * Clase Producto
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    /**
     * Constructor de la clase Producto con todos sus parametros 
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad del producto
     */
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    /**
     * Getter del parametro Nombre
     * @return Devuelve el valor del parametro Nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del parametro Precio
     * @return Devuelve el valor del parametro Precio
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Getter del parametro Cantidad
     * @return Devueve el valor del parametro Cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
}
