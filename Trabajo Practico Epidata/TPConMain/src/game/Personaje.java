package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.atributo.Atributo;

// Clase que hereda de Enfrentable.
public class Personaje extends Enfrentable {

	private Map<String, Atributo> atributos;

	// Constructor:
	public Personaje(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
		this.atributos = new HashMap<>();
	}

	// Obtiene el valor de un atributo específico según la clave proporcionada.
	// Si el atributo no existe, retorna 0.
	@Override
	public float getValorAtributo(String key) {

		Atributo atri = atributos.get(key);
		if (atri != null) {
			return atri.getValor(this);
		} else {
			return 0.0f;
		}
	}

	// Retorna una lista consigo mismo.
	@Override
	protected List<Personaje> getPersonajes() {

		List<Personaje> personajes = new ArrayList<>();
		personajes.add(this);
		return personajes;
	}

	// Agrega un atributo al personaje solo si no existe uno con la misma clave.
	public boolean addAtributo(String k, Atributo a) {

		if (!atributos.containsKey(k)) {
			atributos.put(k, a);
			return true;
		}

		return false;
	}

	// Lo estoy utilizando para ir viendo como va mi código a medida que avanza.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString()); // Llama a toString de Enfrentable
		sb.append("\nAtributos:\n");
		for (Map.Entry<String, Atributo> entry : atributos.entrySet()) {
			sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue().getValor(this)).append("\n");
		}
		return sb.toString();
	}

}
