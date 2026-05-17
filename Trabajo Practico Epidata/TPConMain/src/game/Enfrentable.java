package game;

import java.util.Comparator;
import java.util.List;

// Enfrentable es una clase abstracta, la van a heredar Personaje y Liga por el momento.
public abstract class Enfrentable {

	protected String nombre;
	protected String nombreFantasia;

	// Constructor:
	public Enfrentable(String nombre, String nombreFantasia) {
		super();
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
	}

	// Retorna el nombre del enfrentable.
	public String getNombre() {
		return nombre;
	}

	// Retorna el nombre de fantasía del enfrentable.
	public String getNombreFantasia() {
		return nombreFantasia;
	}

	// Método abstracto que devuelve el valor de un atributo específico,
	// Personaje y Liga van a implementar este método.
	public abstract float getValorAtributo(String key);

	// Enfrenta un Enfrentable con otro Enfrentable usando un Comparator.
	// Retorna el enfrentable ganador o null en caso de empate.
	public Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c) {

		int a = c.compare(this, e);

		if (a > 0) {
			return this;
		} else if (a < 0) {
			return e;
		} else
			return null;

	}

	// Ordena una lista de personajes de acuerdo a un Comparator.
	public List<Personaje> ordenar(Comparator<Personaje> c) {

		List<Personaje> personajes = getPersonajes();
		personajes.sort(c);
		return personajes;
	}

	// Método abstracto que debe retornar todos los personajes asociados con este
	// enfrentable.
	protected abstract List<Personaje> getPersonajes();

	// Lo estoy utilizando para ir viendo como va mi código a medida que avanza.
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Nombre de Fantasía: " + nombreFantasia;
	}
}
