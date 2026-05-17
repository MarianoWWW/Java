package game.atributo;

import game.Enfrentable;

// Atributo Condicional:
// Su valor depende de una comparación entre dos atributos de un Enfrentable.
// Si el valor del primer atributo es mayor que el segundo, 
// devuelve el valor de keyThen. Si es menor, devuelve el valor de keyElse.
// Si hay igualdad, retorna NaN.
public class AtributoCondicional implements Atributo {

	// Claves que se usarán para acceder a los valores de los atributos.
	private String key1;
	private String key2;
	// Atributos que se devolverán dependiendo de la condición.
	private Atributo keyThen;
	private Atributo keyElse;

	// Constructor:
	public AtributoCondicional(String key1, String key2, Atributo keyThen, Atributo keyElse) {
		super();
		this.key1 = key1;
		this.key2 = key2;
		this.keyThen = keyThen;
		this.keyElse = keyElse;
	}

	// Obtiene el valor de este atributo basado en una condición entre dos atributos
	// del Enfrentable. Si key1 es mayor que key2, devuelve el valor de `keyThen`.
	// Si es menor, devuelve el valor de `keyElse`. Si son iguales, retorna.
	@Override
	public float getValor(Enfrentable e) {

		// Obtiene los valores de los atributos especificados por key1 y key2 en
		// Enfrentable.
		float v1 = e.getValorAtributo(key1);
		float v2 = e.getValorAtributo(key2);

		// Evalúa
		if (v1 > v2) {
			return keyThen.getValor(e);
		} else if (v1 < v2) {
			return keyElse.getValor(e);
		} else {
			return Float.NaN;
		}
	}

}
