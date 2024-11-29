/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.entidades.popocamiones;

import java.util.ArrayList;
import java.util.List;

public class Autobus {
    private List<String> terminales;
    private boolean[] asientos; // true si está ocupado, false si está disponible
    private List<Pasajero> pasajeros;
    private List<Pasajero> pasajerosParaReporte; // Lista separada para el reporte final

    public Autobus() {
        this.terminales = new ArrayList<>();
        this.asientos = new boolean[20]; // 20 asientos (0-19)
        this.pasajeros = new ArrayList<>();
        this.pasajerosParaReporte = new ArrayList<>(); // Inicializar la lista de reporte

        // Inicializando las terminales (orden de paradas)
        terminales.add("Navojoa");
        terminales.add("Obregón");
        terminales.add("Empalme");
        terminales.add("Guaymas");
        terminales.add("Hermosillo");
        terminales.add("Santa Ana");
        terminales.add("Magdalena");
        terminales.add("Imuris");
        terminales.add("Nogales");
    }

    public List<String> getTerminales() {
        return terminales;
    }

    public boolean[] getAsientos() {
        return asientos;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public List<Pasajero> getPasajerosParaReporte() {
        return pasajerosParaReporte;
    }

    public boolean venderBoleto(int asiento, String nombre, String destino, double precio) {
        if (asiento < 1 || asiento > 20 || asientos[asiento - 1]) {
            System.out.println("El asiento seleccionado no está disponible.");
            return false; // Si el asiento no es válido o está ocupado
        }

        // Crear pasajero
        Pasajero pasajero = new Pasajero(nombre, destino, precio, asiento);

        // Vender boleto
        asientos[asiento - 1] = true; // Marcar asiento como ocupado
        pasajeros.add(pasajero); // Añadir a la lista de pasajeros actuales
        pasajerosParaReporte.add(pasajero); // Añadir a la lista de reporte final
        System.out.println("Boleto vendido con éxito.");
        return true;
    }

    public void bajarPasajerosEnTerminal(String terminal) {
        // Liberar los asientos ocupados por los pasajeros que se bajan
        pasajeros.stream()
                .filter(p -> p.getDestino().equalsIgnoreCase(terminal))
                .forEach(p -> asientos[p.getAsiento() - 1] = false); // Liberar asiento

        // Eliminar los pasajeros que se bajan
        pasajeros.removeIf(p -> p.getDestino().equalsIgnoreCase(terminal));
    }
}


