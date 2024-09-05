package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	protected int	COSTO_POR_KM;
	public CalculadoraTarifasTemporadaAlta() {
		COSTO_POR_KM=1000;
		
	}
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
	 int costoBase= calcularDistanciaVuelo(vuelo.getRuta())* COSTO_POR_KM;
        return costoBase;
	}
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento = 0.0;
        // Asegurarse de que el descuento esté entre 0 y 1
        return Math.min(Math.max(descuento, 0.0), 1.0);
	}
}
