package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
	private java.lang.String codigoRuta;//El código para la ruta
	private Aeropuerto	destino; //El aeropuerto destino de la ruta
	private java.lang.String horaLlegada; //La hora esperada de llegada, expresada con una cadena de cuatro dígitos.
	private java.lang.String horaSalida; //La hora esperada de salida, expresada con una cadena de cuatro dígitos.
	private Aeropuerto origen; //El aeropuerto origen de la ruta

	public Ruta(Aeropuerto origen, Aeropuerto destino, java.lang.String horaSalida, java.lang.String horaLlegada, java.lang.String codigoRuta){
		this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigoRuta = codigoRuta;
	}
	public String getCodigoRuta() {
        return codigoRuta;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }
    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }
    public int getDuracion() {
        int horasSalida = getHoras(horaSalida);
        int minutosSalida = getMinutos(horaSalida);
        int horasLlegada = getHoras(horaLlegada);
        int minutosLlegada = getMinutos(horaLlegada);

        int duracionHoras = horasLlegada - horasSalida;
        int duracionMinutos = minutosLlegada - minutosSalida;

        return duracionHoras * 60 + duracionMinutos;
    }
    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }   
}
