package game.comparator;

import java.util.Comparator;

import game.Enfrentable;

// Compara dos Enfrentables en función de un atributo.
public class ComparatorCriterioSimple implements Comparator<Enfrentable> {

	private String atributo;

	// Constructor:
	public ComparatorCriterioSimple(String atributo) {
		super();
		this.atributo = atributo;
	}

	// Compara dos objetos Enfrentable en función del valor del atributo
	// especificado en el Comparator.
	// Parámetros:
	// e1 - Primer objeto Enfrentable.
	// e2 - Segundo objeto Enfrentable.
	// Retorna:
	// Un valor positivo si el valor del atributo en e1 es mayor que en e2,
	// un valor negativo si el valor en e1 es menor que en e2, o 0 si son iguales.
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {

		float v1 = e1.getValorAtributo(atributo);
		float v2 = e2.getValorAtributo(atributo);

		if (v1 > v2)
			return 1;
		if (v1 < v2)
			return -1;
		return 0;

		// Nota: Podría usarse Float.compare(v1, v2) para lograr el mismo resultado.
	}
}
