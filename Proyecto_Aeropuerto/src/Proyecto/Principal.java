package Proyecto;

import java.util.Scanner;

public class Principal {
	static Scanner entrada = new Scanner(System.in);
	final static int num = 4;
	static Aeropuerto aeropuertos[] = new Aeropuerto[num];
	
	public static void main(String[] args) {
		
		insertarDatosAeropuerto(aeropuertos);
		menu();
	}
	


	public static void insertarDatosAeropuerto(Aeropuerto[] aeropuerto) {
		aeropuerto[0] = new AeropuertoPublico(80_000_000, "Jorge Chavez", "Lima", "Peru");
		aeropuerto[0].insertarCompañia(new Compañia("AeroPeru"));
		aeropuerto[0].insertarCompañia(new Compañia("LATAM"));
		aeropuerto[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB20", "Lima", "Madrid", 415.95, 150));
		aeropuerto[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB21", "Lima", "Buenos Aires", 180.75, 120));
		aeropuerto[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC12", "Lima", "Londres", 580, 180));
		aeropuerto[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajeros(new Pasajero("Alejandro", "G42WFGB", "Española"));
		aeropuerto[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajeros(new Pasajero("Sonia", "Y65TRHU", "Peruana"));
		aeropuerto[0].getCompañia("LATAM").getVuelo("FC12").insertarPasajeros(new Pasajero("John", "J89GFTE", "Inglesa"));
		
		aeropuerto[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "Madrid");
		aeropuerto[1].insertarCompañia(new Compañia("AirEuropa"));
		String empresas[] = {"Cobresol", "Anguila34"};
		((AeropuertoPrivado)aeropuerto[1]).insertaEmpresas(empresas);
		aeropuerto[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("SE21", "Madrid", "Sevilla", 380.15, 100));
		aeropuerto[1].getCompañia("AirEuropa").getVuelo("SE21").insertarPasajeros(new Pasajero("Paco", "SE129DF", "Española"));
		
		aeropuerto[2] = new AeropuertoPublico(200_000_000, "Aeropuerto Bogota", "Bogota", "Colombia");
		aeropuerto[2].insertarCompañia(new Compañia("AirAmerica"));
		aeropuerto[2].insertarCompañia(new Compañia("VuelaBogota"));
		aeropuerto[2].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE30", "Bogota", "Lima", 295.99, 125));
		aeropuerto[2].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE31", "Bogota", "Lima", 295.99, 125));
		aeropuerto[2].getCompañia("AirAmerica").getVuelo("AE30").insertarPasajeros(new Pasajero("Julia","GF66YTR", "Francesa"));
		aeropuerto[2].getCompañia("AirAmerica").getVuelo("AE31").insertarPasajeros(new Pasajero("Rebeca", "GH67HSK", "Francesa"));
		
		aeropuerto[3] =new AeropuertoPublico(400_000_000, "Aeropuerto Mexico", "Mexico", "Mexico");
		aeropuerto[3].insertarCompañia(new Compañia ("AeroMexico"));
		aeropuerto[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB2042", "Mexico", "Colombia", 299, 90));
		aeropuerto[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB2043", "Mexico", "Colombia", 299, 90));
		aeropuerto[3].getCompañia("AeroMexico").getVuelo("IB2042").insertarPasajeros(new Pasajero("Laura", "WE34RTWH", "Alemana"));
			
		}

	private static void menu() {
		String nombreAeropuerto;
		int opcion;
		Aeropuerto aeropuerto;
		do {
			System.out.println("\t.Menu:.");
			System.out.println("");
			System.out.println("1. Ver Aeropuertos gestionados(Publicos o Privados)");
			System.out.println("2. Ver empresas(Aeropuertos Privados) o subvenciones (Aeropuertos Publicos)");
			System.out.println("3. Ver Lista de companias de un Aeropuerto");
			System.out.println("4. Ver Lista de vuelos por Compania");
			System.out.println("5. Listar posibles vuelos de Origen a Destino");
			System.out.println("6. Salir");
			System.out.println("");
			System.out.println("Opcion:");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch(opcion) {
			case 1: //Ver Aeropuertos gestionados(Publicos o Privados)
				System.out.println("");
				mostrarDatosAeropuertos(aeropuertos);
				break;
			case 2: //Ver empresas(Aeropuertos Privados) o subvenciones (Aeropuertos Publicos)
				System.out.println("");
				mostrarPatrocinio(aeropuertos);
				break;
			case 3://Ver Lista de companias de un Aeropuerto
				
				System.out.println("Escribe el nombre de un Aeropuerto: ");
				nombreAeropuerto = entrada.nextLine();
				aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if(aeropuerto == null) {
					System.out.println("El aeropuerto no existe");
				}else {
					mostrarCompañias(aeropuerto);
				}
				break;
			case 4: //Ver Lista de vuelos por Compania
				break;
			case 5:// Listar posibles vuelos de Origen a Destino
				break;
			case 6: //salir
				System.out.println("Hasta pronto!!!");
				break;
			default:
				System.out.println("Error, se equivoco de opcion!");
				break;
			}
			System.out.println("");
		} while (opcion != 6);
		
	}
	public static void mostrarDatosAeropuertos(Aeropuerto[] aeropuertos ) {
		for (int i = 0; i < aeropuertos.length; i++) {
			if (aeropuertos[i] instanceof AeropuertoPrivado) {
				System.out.println("Aeropuerto Privado");
				System.out.println("Nombre: " + aeropuertos[i].getNombre());
				System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
				System.out.println("Pais: " + aeropuertos[i].getPais() );
			}else {
				System.out.println("Aeropuerto Publico");
				System.out.println("Nombre: " + aeropuertos[i].getNombre());
				System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
				System.out.println("Pais: " + aeropuertos[i].getPais() );
			}
			System.out.println("");
		}
		
	}
	
	public static void mostrarPatrocinio(Aeropuerto[] aeropuerto) {
		String empresas[];
			
			
		for (int i = 0; i < aeropuerto.length; i++) {
			if(aeropuerto[i] instanceof AeropuertoPrivado) {
			System.out.println("Aeropuerto Privado: " + aeropuerto[i].getNombre());
			empresas = ((AeropuertoPrivado)aeropuerto[i]).getListaEmpresas();
			System.out.println("Empresas: ");
			for (int j = 0; j < empresas.length; j++) {
				System.out.println(empresas[j]);
			}
 		}else {
 			System.out.println("Aeropuerto Publico" + aeropuerto[i].getNombre());
 			System.out.println("Subvencion: " + ((AeropuertoPublico)aeropuerto[i]).getSubvencion());
 		}
			System.out.println("");
			
		}
	}

	public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto[] aeropuerto) {
		boolean encontrado = false;
		int i = 0;
		Aeropuerto aero = null;
		
		while ((!encontrado) && (i > aeropuerto.length)) {
			if(nombre.equals(aeropuerto[i].getNombre())){
				encontrado = true;
				aero = aeropuerto[i];
			}
			i++;
		}
		return aero;
	}
	
	public static void mostrarCompañias(Aeropuerto aeropuerto) {
		System.out.println("Las companias del Aeropuerto: " + aeropuerto.getNombre());
		for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
			System.out.println(aeropuerto.getCompañia(i).getNombreCompañia());
		}
	}
}
