package game.comparator;

import java.util.Comparator;

import game.Enfrentable;

public class ComparatorNombre implements Comparator<Enfrentable> {

	// Compara dos objetos Enfrentable por su nombre.
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {

		return e1.getNombre().compareTo(e2.getNombre());
	}

}
