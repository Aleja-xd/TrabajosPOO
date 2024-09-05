package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.Random;

public class ClientePersonal extends Cliente {
	public static final String PERSONAL = "Personal";
	public ClientePersonal(java.lang.String nombre) {
		
	}
    	
	
	@Override
	public String getIdentificador() {
		Random random = new Random();
		int codigoAleatorio = random.nextInt(5000); // Genera un número entero aleatorio entre 0 y 5000
        String codigo = Integer.toString(codigoAleatorio);
		return codigo;
	}

	@Override
	public String getTipoCliente() {
		return PERSONAL;
	}

}
