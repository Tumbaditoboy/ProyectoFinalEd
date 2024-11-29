/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.entidades.popocamiones;

import java.util.ArrayList;
import java.util.List;

public class Autobus {
    private List<String> terminales;
    private boolean[] asientos; 
    private List<Pasajero> pasajeros;
    private List<Pasajero> pasajerosParaReporte; 

    public Autobus() {
        this.terminales = new ArrayList<>();
        this.asientos = new boolean[20]; 
        this.pasajeros = new ArrayList<>();
        this.pasajerosParaReporte = new ArrayList<>(); 

       
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
            return false; 
        }

       
        Pasajero pasajero = new Pasajero(nombre, destino, precio, asiento);

       
        asientos[asiento - 1] = true; 
        pasajeros.add(pasajero); 
        pasajerosParaReporte.add(pasajero); 
        System.out.println("Boleto vendido con éxito.");
        return true;
    }

    public void bajarPasajerosEnTerminal(String terminal) {
       
        pasajeros.stream()
                .filter(p -> p.getDestino().equalsIgnoreCase(terminal))
                .forEach(p -> asientos[p.getAsiento() - 1] = false); 

       
        pasajeros.removeIf(p -> p.getDestino().equalsIgnoreCase(terminal));
    }
}


