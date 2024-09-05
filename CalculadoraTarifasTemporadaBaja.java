package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	public CalculadoraTarifasTemporadaBaja() {
		
	}
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int costoBase= 0;
		if (cliente.getTipoCliente().equals("Natural")){
		   costoBase= calcularDistanciaVuelo(vuelo.getRuta())* COSTO_POR_KM_NATURAL;
		}else 
		   costoBase= calcularDistanciaVuelo(vuelo.getRuta())* COSTO_POR_KM_CORPORATIVO;
        return costoBase;
}
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento = 0.0;
        if (cliente.getTipoCliente().equals("Corporativo")) {
        	 if (cliente.getTipoCliente().equals(ClienteCorporativo.PEQUENA )){
            descuento = DESCUENTO_PEQ; // 100% de descuento para clientes VIP
        	 }
        	 if (cliente.getTipoCliente().equals(ClienteCorporativo.MEDIANA)) {
                 descuento= DESCUENTO_MEDIANAS; // 100% de descuento para clientes VIP
             	 }
        	 if (cliente.getTipoCliente().equals(ClienteCorporativo.GRANDE)) {
                 descuento = DESCUENTO_GRANDES; // 100% de descuento para clientes VIP
             	 }
        } else 
        	descuento= 0.0;

        // Asegurarse de que el descuento esté entre 0 y 1
        return Math.min(Math.max(descuento, 0.0), 1.0);
	}
	 protected final int COSTO_POR_KM_NATURAL=600;
	 protected final int COSTO_POR_KM_CORPORATIVO=600;
	 protected final double DESCUENTO_PEQ=	0.02;
	 protected final double DESCUENTO_MEDIANAS=0.1;
	 protected final double DESCUENTO_GRANDES=0.2;
}
