package game.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import game.Enfrentable;

// ComparatorCompuesto permite comparar dos objetos Enfrentable en función de múltiples criterios.
// Cada criterio se define mediante un Comparator<Enfrentable> individual en una lista.
// La comparación evalúa cada criterio y acumula victorias para cada Enfrentable.
// Al final, el Enfrentable con más victorias es considerado el ganador.
public class ComparatorCompuesto implements Comparator<Enfrentable> {

	// Lista de comparadores que se utilizarán para comparar.
	private List<Comparator<Enfrentable>> comparators;

	// Constructores:
	public ComparatorCompuesto() {

		this.comparators = new ArrayList<>();
	}

	public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) {
		super();
		this.comparators = comparators;
	}

	// Agrega un comparador al final de la lista de comparadores.
	public boolean addComparator(Comparator<Enfrentable> c) {

		return comparators.add(c);
	}

	// Agrega un comparador en una posición específica de la lista de comparadores.
	public boolean addComparator(Comparator<Enfrentable> c, int index) {

		// Verifica que el índice esté dentro del rango válido de la lista.
		if (index >= 0 && index <= comparators.size()) {
			comparators.add(index, c);
			// Retorna true indicando que el comparador se agregó.
			return true;
		}
		// Retorna false si el índice es inválido.
		return false;
	}

	// Compara dos objetos Enfrentable (e1 y e2) basándose en múltiples criterios.
	// Cada criterio está representado por un Comparator en la lista "comparators".
	// La comparación se realiza en varias etapas, una por cada comparador de la
	// lista,
	// y para cada etapa se contabiliza el "ganador" de ese criterio.
	//
	// Al final de todas las comparaciones:
	// Si e1 tiene más victorias en los criterios, retorna 1.
	// Si e2 tiene más victorias en los criterios, retorna -1.
	// Si ambos tienen el mismo número de victorias, retorna 0 es un empate.
	public int compare(Enfrentable e1, Enfrentable e2) {
		int e1Vic = 0;
		int e2Vic = 0;

		// Realiza la comparación utilizando cada comparador
		for (Comparator<Enfrentable> comparator : comparators) {
			int comparisonResult = comparator.compare(e1, e2);
			if (comparisonResult > 0) {
				e1Vic++; // e1 gana este criterio
			} else if (comparisonResult < 0) {
				e2Vic++; // e2 gana este criterio
			}
		}

		// Determina el ganador basado en las victorias acumuladas
		if (e1Vic > e2Vic) {
			return 1; // e1 gana
		} else if (e2Vic > e1Vic) {
			return -1; // e2 gana
		} else {
			return 0; // Empate
		}
	}
}