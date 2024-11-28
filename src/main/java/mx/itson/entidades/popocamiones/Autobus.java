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

    public Autobus() {
        this.terminales = new ArrayList<>();
        this.asientos = new boolean[20]; // 20 asientos (0-19)
        this.pasajeros = new ArrayList<>();

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

    public boolean venderBoleto(int asiento, String nombre, String destino, double precio) {
        if (asiento < 1 || asiento > 20 || asientos[asiento - 1]) {
            System.out.println("El asiento seleccionado no está disponible.");
            return false; // Si el asiento no es válido o está ocupado
        }

        // Vender boleto
        asientos[asiento - 1] = true; // Marcar asiento como ocupado
        pasajeros.add(new Pasajero(nombre, destino, precio, asiento));
        System.out.println("Boleto vendido con éxito.");
        return true;
    }

    public void mostrarEstadoAsientos() {
        System.out.println("\nEstado de los Asientos:");
        for (int i = 0; i < asientos.length; i++) {
            System.out.print("Asiento " + (i + 1) + ": ");
            if (asientos[i]) {
                System.out.print("Ocupado  ");
            } else {
                System.out.print("Disponible  ");
            }
            if ((i + 1) % 5 == 0) {
                System.out.println(); // Nueva línea cada 5 asientos
            }
        }
        System.out.println();
    }

    public void mostrarReporte() {
        double totalGanancia = 0;
        System.out.println("\n--- Reporte de Boletos Vendidos ---");
        for (Pasajero pasajero : pasajeros) {
            System.out.println(pasajero);
            totalGanancia += pasajero.getPrecio();
        }
        System.out.println("\nTotal de ganancia: " + totalGanancia);
    }

    public void bajarPasajerosEnTerminal(String terminal) {
        // Imprimir cuantos pasajeros se bajan en cada terminal
        long count = pasajeros.stream().filter(p -> p.getDestino().equalsIgnoreCase(terminal)).count();
        System.out.println("En la terminal de " + terminal + ", se bajan " + count + " pasajeros.");

        // Eliminar los pasajeros que se bajan
        pasajeros.removeIf(p -> p.getDestino().equalsIgnoreCase(terminal));
    }
}

