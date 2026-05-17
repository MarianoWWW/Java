package game;

import java.util.Scanner;

import game.atributo.AtributoOperacion;
import game.atributo.AtributoSimple;
import game.comparator.ComparatorCompuesto;
import game.comparator.ComparatorCriterioSimple;

import game.atributo.Atributo;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Juego juego = new Juego();
		// A let, la voy a utilizar repetidas veces.
		char let;
		// Unos cuantos Pre-definidos, así es más rápido testear el juego.
		cargaPredefinidos(juego);

		System.out.println("Bienvenidos la juego de Heroes y Villanos.\n"
				+ "En el cual se pueden enfrentar tanto personajes como Ligas.\n"
				+ "Para iniciar, al menos debes cargar dos personajes o Ligas.\n\n");

		// Mi bucle principal.
		do {
			System.out.println("¿Deseas agregar un Personaje, Liga, subLiga, Jugar o Terminar? (p/L/s/J/t): ");

			let = Character.toLowerCase(sc.next().charAt(0));
			sc.nextLine(); // Limpio el buffer en varias ocasiones.

			// Primero plantee un par de ifs, cuando me di cuenta que tenía muchos, decanté
			// por el switch.
			switch (let) {
			case 'p' -> cargaPersonajes(sc, juego);
			case 'l', 's' -> cargaLiga(juego, let, sc);
			case 'j' -> cargaJuego(juego, sc);
			case 't' -> System.out.println("\nEspero te hayas divertido lo mismo que yo programándolo !!! :)");
			default -> System.out.println("Apretaste cualca. Por favor, intenta nuevamente.");
			}

		} while (let != 't');

		sc.close();
	}

	// Método para cargar un nuevo Personaje.
	public static void cargaPersonajes(Scanner sc, Juego juego) {

		char atri;

		System.out.println("Ingrese el nombre del Personaje : ");
		String perso = sc.nextLine();
		System.out.println("Ingrese el nombre de fantasía del Personaje : ");
		String persof = sc.nextLine();
		Personaje personaje = new Personaje(perso, persof);
		System.out.println("\nHay que agregarle un atributo al menos al Personaje.\n"
				+ "Sino va a perder siempre. Ejemplo: fuerza, velocidad, edad, etc.");

		do {
			System.out.println("¿Qué atributo desear agregarle a " + persof + "? : ");
			String at = sc.nextLine().toLowerCase();
			System.out.println("¿Nivel del atributo? : ");
			float value = sc.nextFloat();
			sc.nextLine();

			Atributo nuevoA = new AtributoSimple(value);

			if (!personaje.addAtributo(at, nuevoA)) {
				System.out.println("Ese atributo ya lo posee.");
			}

			System.out.println("¿Deseas agregar otro atributo? (s/n): ");
			atri = Character.toLowerCase(sc.next().charAt(0));
			sc.nextLine();
		} while (atri == 's');

		if (!juego.addEnfrentable(personaje)) {
			System.out.println("Ese Personaje ya fue agregado.");
		}
	}

	// Método para cargar una Liga o subLiga.
	public static void cargaLiga(Juego juego, char let, Scanner sc) {

		String tipoL = let == 'l' ? "Liga" : "SubLiga";
		System.out.print("Ingrese el nombre de la " + tipoL + ": ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese el nombre de fantasía de la " + tipoL + ": ");
		String nombreFantasia = sc.nextLine();
		Liga liga = new Liga(nombre, nombreFantasia);

		// Bucle para agregar integrantes a la Liga o subLiga.
		do {
			System.out.print("¿Desea agregar un integrante a la " + tipoL + "? (s/n): ");
			let = Character.toLowerCase(sc.next().charAt(0));
			sc.nextLine();
			if (let == 's') {
				System.out.println("Seleccione un personaje por nombre:");
				for (Enfrentable e : juego.getEnfrentables()) {
					System.out.println(e);
				}
				String personajeSeleccionado = sc.nextLine();

				Enfrentable personaje = null;
				for (Enfrentable e : juego.getEnfrentables()) {
					if (e.getNombre().equals(personajeSeleccionado)) {
						personaje = e;
						break;
					}
				}

				if (personaje != null) {
					if (liga.addIntegrante(personaje)) {
						System.out.println("Integrante agregado a la " + tipoL + ".");
					} else {
						System.out.println("El integrante ya está en la " + tipoL + ".");
					}
				} else {
					System.out.println("No existe ese personaje.");
				}
			}
		} while (let == 's');

		// Acá se intenta agregar la Liga o subLiga al juego.
		if (juego.addEnfrentable(liga)) {
			System.out.println(tipoL + " agregada correctamente.");
		} else {
			System.out.println("La " + tipoL + " ya existe.");
		}
	}

	// Método para iniciar un juego.
	public static void cargaJuego(Juego juego, Scanner sc) {

		Enfrentable e1 = null;
		Enfrentable e2 = null;

		// Muestra la lista de enfrentables disponibles
		System.out.println("Esta es la lista de personajes y ligas que podes elegir para enfrentarse.");
		for (Enfrentable e : juego.getEnfrentables()) {
			System.out.println(e.getNombre() + " (" + e.getNombreFantasia() + ")");
		}
		System.out.println("Elige los nombres de los dos personajes o ligas a enfrentar:");
		String n1 = sc.nextLine();
		String n2 = sc.nextLine();

		// Busca los enfrentables seleccionados.
		for (Enfrentable e : juego.getEnfrentables()) {
			if (e.getNombre().equals(n1)) {
				e1 = e;
			}
			if (e.getNombre().equals(n2)) {
				e2 = e;
			}
		}

		// Verifica si ambos enfrentables fueron encontrados.
		if (e1 == null || e2 == null) {
			System.out.println("Uno o ambos personajes no fueron cargados.");
			return;
		}

		System.out.println("¿Deseas hacer un enfrentamiento básico "
				+ "(entre dos personajes y un atributo simple)\n o un enfrentamiento compuesto? (B/C) :");
		char let = Character.toLowerCase(sc.next().charAt(0));
		sc.nextLine();

		if (let == 'b') {
			eBasico(juego, e1, e2, sc);
		} else if (let == 'c') {
			eCompuesto(juego, e1, e2, sc);
		}
	}

	// Método para realizar un enfrentamiento básico.
	public static void eBasico(Juego juego, Enfrentable e1, Enfrentable e2, Scanner sc) {
		System.out.println("Ingresa el atributo por el cual deseas determinar el ganador:");
		String atributo = sc.nextLine().toLowerCase();

		ComparatorCriterioSimple comparator = new ComparatorCriterioSimple(atributo);

		// Se determina el ganador o si es empate.
		Enfrentable gana = juego.enfrentar(e1, e2, comparator);

		// Mensajes sobre el resultado del enfrentamiento.
		if (gana != null) {
			System.out.println(gana.getNombre() + " GANO!!!!!!!! ");
		} else {
			System.out.println("Empateee!");
		}
	}

	// Método para realizar un enfrentamiento compuesto.
	public static void eCompuesto(Juego juego, Enfrentable e1, Enfrentable e2, Scanner sc) {
		System.out.println("Ingresa los atributos por los cuales deseas determinar el ganador (separados por comas):");
		String[] atributosIngresados = sc.nextLine().split(",");

		// Creo un comparador compuesto que gestionará múltiples comparadores.
		ComparatorCompuesto comparador = new ComparatorCompuesto();

		// Bucle para procesar cada atributo ingresado.
		for (String atributo : atributosIngresados) {
			atributo = atributo.trim().toLowerCase();

			switch (atributo) {
			case "resistencia":

				// Se crea una instancia del atributo de resistencia.
				ResistenciaAtributo resistencia = new ResistenciaAtributo();
				float valorResistenciaE1 = resistencia.getValor(e1);
				float valorResistenciaE2 = resistencia.getValor(e2);
				comparador.addComparator(
						(enfrentable1, enfrentable2) -> Float.compare(valorResistenciaE1, valorResistenciaE2));
				break;
			case "camuflaje":

				// Se crea una instancia del atributo de camuflaje.
				CamuflajeAtributo camuflaje = new CamuflajeAtributo();
				float valorCamuflajeE1 = camuflaje.getValor(e1);
				float valorCamuflajeE2 = camuflaje.getValor(e2);
				comparador.addComparator(
						(enfrentable1, enfrentable2) -> Float.compare(valorCamuflajeE1, valorCamuflajeE2));
				break;
			case "modernidad":

				// Se crea una instancia del atributo de modernidad.
				ModernidadAtributo modernidad = new ModernidadAtributo();
				float valorModernidadE1 = modernidad.getValor(e1);
				float valorModernidadE2 = modernidad.getValor(e2);
				comparador.addComparator(
						(enfrentable1, enfrentable2) -> Float.compare(valorModernidadE1, valorModernidadE2));
				break;
			default:

				// Para los demás atributos, se utiliza el comparador simple.
				comparador.addComparator(new ComparatorCriterioSimple(atributo));
			}
		}

		// Se compara los dos enfrentables usando el comparador compuesto.
		int resultado = comparador.compare(e1, e2);
		if (resultado > 0) {
			System.out.println(e1.getNombre() + " GANO!!!!!!!! ");
		} else if (resultado < 0) {
			System.out.println(e2.getNombre() + " GANO!!!!!!!! ");
		} else {
			System.out.println("Empateee!");
		}
	}

	// Clase para calcular el atributo de resistencia, extendiendo de
	// AtributoOperacion.
	public static class ResistenciaAtributo extends AtributoOperacion {

		// Contructor:
		public ResistenciaAtributo() {
			super("fuerza", "velocidad");
		}
	}

	// Clase para calcular el atributo de camuflaje, extendiendo de
	// AtributoOperacion.
	public static class CamuflajeAtributo extends AtributoOperacion {

		// Contructor:
		public CamuflajeAtributo() {
			super("invisibilidad", "fuerza");
		}
	}

	// Clase para calcular el atributo de modernidad, extendiendo de
	// AtributoOperacion.
	public static class ModernidadAtributo extends AtributoOperacion {

		// Contructor:
		public ModernidadAtributo() {
			super("tecnología", "superpoderes");
		}
	}

	// Método para cargar personajes y ligas predefinidos al juego.
	public static void cargaPredefinidos(Juego juego) {

		// Creación de personajes prediseñados con sus atributos.
		Personaje al = new Personaje("Al", "Bundy");
		al.addAtributo("fuerza", new AtributoSimple(900));
		al.addAtributo("velocidad", new AtributoSimple(70));
		al.addAtributo("edad", new AtributoSimple(77));
		Personaje hom = new Personaje("Peter", "Hombre Araña");
		hom.addAtributo("fuerza", new AtributoSimple(999.99f));
		hom.addAtributo("velocidad", new AtributoSimple(999));
		hom.addAtributo("inteligencia", new AtributoSimple(55));
		Personaje ml = new Personaje("Gargamel", "Gargamel");
		ml.addAtributo("fuerza", new AtributoSimple(0.55f));
		ml.addAtributo("velocidad", new AtributoSimple(60));
		ml.addAtributo("inteligencia", new AtributoSimple(66.666f));
		Personaje mal = new Personaje("Alexander", "Lex Luthor");
		mal.addAtributo("fuerza", new AtributoSimple(867.77f));
		mal.addAtributo("velocidad", new AtributoSimple(90));
		mal.addAtributo("inteligencia", new AtributoSimple(999.999f));

		// Se añaden los personajes al juego.
		juego.addEnfrentable(al);
		juego.addEnfrentable(hom);
		juego.addEnfrentable(ml);
		juego.addEnfrentable(mal);

		// Creación de una Liga de Villanos y adición de personajes a ella.
		Liga lV = new Liga("Villanos", "Dos malotosos");
		lV.addIntegrante(ml);
		lV.addIntegrante(mal);
		juego.addEnfrentable(lV);
	}
}
