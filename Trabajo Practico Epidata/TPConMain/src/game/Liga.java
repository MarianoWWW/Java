package game;

import java.util.ArrayList;
import java.util.List;

// Liga hereda de Enfrentable
// Una liga puede tener uno o varios integrantes (Enfrentables),
// que pueden ser personajes o incluso otras ligas (Sub Ligas).
public class Liga extends Enfrentable {

	private List<Enfrentable> integrantes;

	// Constructores:
	public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) {
		super(nombre, nombreFantasia);
		this.integrantes = integrantes;
	}

	public Liga(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
		this.integrantes = new ArrayList<>();
	}

	// Agrega un integrante a la liga si no está ya presente.
	public boolean addIntegrante(Enfrentable e) {

		if (e == this) {
			System.out.println("No podes agregar una liga dentro de si misma.");
			return false;
		}

		if (!integrantes.contains(e)) {
			return integrantes.add(e);
		}
		return false;
	}

	// Obtiene el valor de un atributo específico según la clave proporcionada.
	// Si el atributo no existe, retorna 0.
	@Override
	public float getValorAtributo(String key) {
		if (integrantes.isEmpty()) {
			return 0.0f; // Si no hay integrantes, el promedio es 0
		}

		float total = 0.0f;
		int count = 0; // Contador para los integrantes que tienen el atributo

		for (Enfrentable e : integrantes) {
			float valor = e.getValorAtributo(key);
			if (valor != 0.0f) { // Verificamos si el valor es distinto de 0
				total += valor;
				count++; // Solo contamos si el valor no es 0
			}
		}

		// Si no se encontraron atributos válidos, devolver 0
		if (count == 0) {
			return 0.0f;
		}

		return total / count; // Promedio solo de los integrantes que tienen el atributo
	}

	// Retorna una lista de todos los personajes contenidos en la liga.
	// Si algún integrante es otra liga, también se incluyen sus personajes.
	@Override
	protected List<Personaje> getPersonajes() {

		List<Personaje> personajes = new ArrayList<>();
		for (Enfrentable e : integrantes) {
			personajes.addAll(e.getPersonajes());
		}
		return personajes;
	}

	// Lo estoy utilizando para ir viendo como va mi código a medida que avanza.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Liga: ").append(getNombre()).append(" (").append(getNombreFantasia()).append(")\n");
		sb.append("Integrantes:\n");
		for (Enfrentable integrante : integrantes) {
			sb.append(" - ").append(integrante.getNombre()).append(" (").append(integrante.getNombreFantasia())
					.append(")\n");
		}
		return sb.toString();
	}
}
