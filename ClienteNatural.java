package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
	public static final java.lang.String NATURAL= "Natural";
	private java.lang.String nombre;
	
	public ClienteNatural(java.lang.String nombre) {}
	@Override
	public String getTipoCliente() {
		return NATURAL;
	}
	@Override
	public String getIdentificador() {
		return nombre;
	}
}
