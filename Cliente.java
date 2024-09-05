package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public abstract class Cliente extends java.lang.Object {
	private java.util.List<Tiquete>tiquetesSinUsar;
	private java.util.List<Tiquete>tiquetesUsados;
	public Cliente() {
		this.tiquetesUsados = new ArrayList<>();
		this.tiquetesSinUsar = new ArrayList<>();
	}
	 public abstract String getIdentificador();
	 public abstract String getTipoCliente();

    public void agregarTiquete​(Tiquete tiquete) {
    	this.tiquetesSinUsar.add(tiquete);
    }
    public int calcularValorTotalTiquetes() {
    	int total = 0;
    	for (Tiquete tiquete : tiquetesSinUsar) {
            total += tiquete.getTarifa();
        }
        for (Tiquete tiquete : tiquetesUsados) {
            total += tiquete.getTarifa();
        }
        return total;
    }
    public void usarTiquetes​(Vuelo vuelo) {
    	 List<Tiquete> tiquetesAUsar = new ArrayList<>();
         for (Tiquete tiquete : tiquetesSinUsar) {
             if (tiquete.getVuelo().equals(vuelo)) {
                 tiquetesAUsar.add(tiquete);
             }
         }
         tiquetesSinUsar.removeAll(tiquetesAUsar);
         tiquetesUsados.addAll(tiquetesAUsar);
    }
    public List<Tiquete> getTiquetesSinUsar() {
        return tiquetesSinUsar;
    }

    public List<Tiquete> getTiquetesUsados() {
        return tiquetesUsados;
    }
  
}
