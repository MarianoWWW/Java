package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.comparator.ComparatorCompuesto;

public class Juego {

	// Lista de todos los enfrentables (Personajes y Ligas)
	private List<Enfrentable> enfrentables;

	// Constructor:
	public Juego() {
		super();
		this.enfrentables = new ArrayList<>();
	}

	public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator<Enfrentable> c) {

		List<Enfrentable> ganadores = new ArrayList<>();

		// Recorre todos los enfrentables y añade a los que vencen
		for (Enfrentable guerrea : enfrentables) {
			if (c.compare(guerrea, e) > 0) {
				ganadores.add(guerrea);
			}
		}
		return ganadores;
	}

	// Enfrenta dos enfrentables y retorna el ganador. En caso de empate retorna
	// null.
	// Si el comparador es compuesto, realiza una comparación compuesta.
	public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
		if (c instanceof ComparatorCompuesto) {

			// Comparación utilizando el ComparatorCompuesto
			int resultado = c.compare(e1, e2);
			if (resultado > 0) {
				return e1;
			} else if (resultado < 0) {
				return e2;
			} else {
				return null;
			}
		} else {

			// Comparación simple
			int resultadoSimple = c.compare(e1, e2);
			if (resultadoSimple > 0) {
				return e1;
			} else if (resultadoSimple < 0) {
				return e2;
			} else {
				return null;
			}
		}
	}

	// Agrega un enfrentable al juego si no hay otro enfrentable con el mismo
	// nombre.
	public boolean addEnfrentable(Enfrentable e) {

		// Chequea si ya existe un enfrentable con el mismo nombre.
		for (Enfrentable enf : enfrentables) {
			if (enf.getNombre().equals(e.getNombre())) {

				// Si ya existe un enfrentable con el mismo nombre retorna false.
				return false;
			}
		}

		// Acá agrega el enfrentable a la lista.
		enfrentables.add(e);
		return true;
	}

	// Ordena los personajes en la lista de enfrentables según un comparador.
	// También introduje un llamado a chequearRepetidos y getEnfrentables
	// para eliminar duplicados.
	public List<Personaje> ordenarPersonajes(Comparator<Personaje> c) {

		List<Personaje> personajes = new ArrayList<>();

		// Obtiene todos los personajes de cada enfrentable
		for (Enfrentable en : enfrentables) {

			personajes.addAll(en.getPersonajes());
		}

		// Elimina duplicados
		personajes = chequearRepetidos(personajes);

		// Ordena la lista de personajes usando el comparador
		personajes.sort(c);

		return personajes;
	}

	// Este método lo agregué para cumplir con la consigna.
	// Eliminando personajes repetidos, usando Set.
	public List<Personaje> chequearRepetidos(List<Personaje> personajes) {

		Set<Personaje> sinRepe = new HashSet<>(personajes);

		// Convierto Set de nuevo en una lista.
		return new ArrayList<>(sinRepe);
	}

	// Este método lo agregué para cumplir con la consigna.
	// Luego lo voy a aprovechar repetidas veces en mi implementación
	// del juego en la clase Main.
	public List<Enfrentable> getEnfrentables() {
		return enfrentables;
	}

}
