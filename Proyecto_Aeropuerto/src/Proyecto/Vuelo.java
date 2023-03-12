package Proyecto;

public class Vuelo {
	private String identificador;
	private String ciudadOrigen;
	private String ciudadDestino;
	private double precio;
	private int numMaxPasajeros;
	private int numActualPasajeros;
	private Pasajero listaPasajeros[] = new Pasajero[10];
	
	
	public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
		super();
		this.identificador = identificador;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.precio = precio;
		this.numMaxPasajeros = numMaxPasajeros;
	}

	public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros,
			int numActualPasajeros, Pasajero[] listaPasajeros) {
		
		this.identificador = identificador;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.precio = precio;
		this.numMaxPasajeros = numMaxPasajeros;
		this.numActualPasajeros = numActualPasajeros;
		this.listaPasajeros = new Pasajero[numMaxPasajeros];
	}
	
	public void insertarPasajeros(Pasajero pasajero){
		listaPasajeros[numActualPasajeros] = pasajero;
		numActualPasajeros++;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumMaxPasajeros() {
		return numMaxPasajeros;
	}

	public int getNumActualPasajeros() {
		return numActualPasajeros;
	}
	
	public Pasajero getPasajero(int i) {
		return listaPasajeros[i];
	}
	
	public Pasajero getPasajero(String pasaporte) {
		boolean encontrado = false;
		int i = 0;
		Pasajero pasajero = null;
		
		while ((!encontrado) && (i < listaPasajeros.length)) {
			if(pasaporte.equals(listaPasajeros[i].getPasaporte()) ){
				encontrado = true;
				pasajero = listaPasajeros[i];
		}
			i++;
	}
		return pasajero;
}
}
