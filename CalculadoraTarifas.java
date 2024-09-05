package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas extends java.lang.Object {
	public static final double IMPUESTO = 0.19;
	
	public CalculadoraTarifas() {
        // Constructor vacío
    }

    /**
     * Este método calcula cuál debe ser la tarifa total para un vuelo, dado el vuelo y el cliente.
     * La tarifa total está constituida por un costo base, un descuento que podría aplicarse sobre el costo base,
     * y un impuesto que se aplica sobre el costo base menos el descuento.
     * Este método utiliza los métodos calcularCostoBase y calcularPorcentajeDescuento para calcular la tarifa total.
     *
     * @param vuelo El vuelo para el que se quiere calcular la tarifa.
     * @param cliente El cliente para el que se quiere calcular la tarifa.
     * @return El valor completo de la tarifa.
     */
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        int descuento = (int) (costoBase * porcentajeDescuento);
        int costoConDescuento = costoBase - descuento;
        int valorImpuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + valorImpuestos;
    }

    /**
     * Este método calcula cuál debe ser el costo base dado el vuelo y el cliente.
     *
     * @param vuelo El vuelo para el que se quiere calcular la tarifa.
     * @param cliente El cliente para el que se quiere calcular la tarifa.
     * @return El valor base de la tarifa.
     */
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    /**
     * Calcula el porcentaje de descuento que se le debería dar a un cliente dado su tipo y/o su historia.
     * El método retorna un número entre 0 y 1: 0 significa que no hay descuento, y 1 significa que el descuento es del 100%.
     *
     * @param cliente El cliente para el que se quiere conocer el descuento.
     * @return Un porcentaje de descuento, entre 0 y 1.
     */
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    /**
     * Calcula la distancia aproximada en kilómetros para una ruta.
     *
     * @param ruta La ruta para la que se quiere calcular la distancia.
     * @return Una aproximación de la distancia.
     */
    protected int calcularDistanciaVuelo(Ruta ruta) {
    	// Coordenadas del punto de origen
        double lat1 = Math.toRadians(ruta.getOrigen().getLatitud());
        double lon1 = Math.toRadians(ruta.getOrigen().getLongitud());

        // Coordenadas del punto de destino
        double lat2 = Math.toRadians(ruta.getDestino().getLatitud());
        double lon2 = Math.toRadians(ruta.getDestino().getLongitud());

        // Fórmula del haversine
        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Radio de la Tierra en kilómetros
        final double R = 6371.0;
        double distancia = R * c;

        // Redondear la distancia y convertir a entero
        return (int) Math.round(distancia);
    }

    /**
     * Calcula el valor de los impuestos para un tiquete, dado el costo base.
     * Los impuestos se calculan como un porcentaje sobre el costo base, usando la constante IMPUESTO.
     *
     * @param costoBase El valor base del tiquete.
     * @return El valor correspondiente a los impuestos.
     */
    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
}
