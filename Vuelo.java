package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Vuelo extends java.lang.Object {
	/**
     * El avión utilizado para realizar el vuelo
     */
	private Avion avion;
	private Ruta ruta;
	private java.lang.String fecha;
	/**
     * Los tiquetes que ya fueron vendidos para el vuelo
     */
	private java.util.Map<java.lang.String, Tiquete>tiquetes;
	
	 public Vuelo(Ruta ruta, java.lang.String fecha, Avion avion) {
	        this.ruta = ruta;
	        this.fecha = fecha;
	        this.avion = avion;
	        this.tiquetes = new HashMap<>();
	    }
	public Ruta getRuta() {
		return ruta;
	}
	public java.lang.String getFecha(){
		return fecha;
	}
	public Avion getAvion() {
		return avion;
	}
	public Collection<Tiquete> getTiquetes() {
        return tiquetes.values();
    }
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
        if (cantidad > avion.getCapacidad() - tiquetes.size()) {
            throw new VueloSobrevendidoException(this);
        }

        int total = 0;
        for (int i = 0; i < cantidad; i++) {
        	 Random random = new Random();
             int codigoAleatorio = random.nextInt(5000); // Genera un número entero aleatorio entre 0 y 5000
             String codigo = Integer.toString(codigoAleatorio);
            int tarifa = calculadora.calcularTarifa(this, cliente);
            Tiquete tiquete = new Tiquete(codigo, this, cliente, tarifa);
            tiquetes.put(codigo, tiquete);
            total += tarifa;
        }
        return total;
    }
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Vuelo vuelo = (Vuelo) obj;
	        return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion);
	    }
}