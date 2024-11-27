/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.entidades.popocamiones;

public class Pasajero {
    private String nombre;
    private String destino;
    private double precio;
    private int asiento;

    // Constructor
    public Pasajero(String nombre, String destino, double precio, int asiento) {
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.asiento = asiento;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAsiento() {
        return asiento;
    }

    // Método para mostrar los detalles del pasajero
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Destino: " + destino + ", Precio: " + precio + ", Asiento: " + asiento;
    }
}

