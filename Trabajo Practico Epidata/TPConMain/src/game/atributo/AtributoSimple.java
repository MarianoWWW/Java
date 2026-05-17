package game.atributo;

import game.Enfrentable;

public class AtributoSimple implements Atributo {

	// Variable que almacena el valor float del atributo.
	private float value;

	// Constructor:
	public AtributoSimple(float value) {
		super();
		this.value = value;
	}

	// Obtiene el valor del atributo asociado al Enfrentable.
	// Dado que este atributo es simple, siempre devuelve
	// el mismo valor.
	@Override
	public float getValor(Enfrentable e) {

		return value;
	}

	// Establece un nuevo valor para el atributo.
	public void setValor(float value) {

		this.value = value;
	}

}
