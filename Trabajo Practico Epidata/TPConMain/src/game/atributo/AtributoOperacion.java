package game.atributo;

import game.Enfrentable;
import game.Main.CamuflajeAtributo;
import game.Main.ModernidadAtributo;
import game.Main.ResistenciaAtributo;

// Hice esta clase abstracta, que representa un atributo que realiza una operación entre
// dos valores. Las subclases definen cómo se calcula el valor. (Al final para mantener
// el espíritu del TP, no cree las subclases acá, donde sería más fácil de encontrarlas, 
// hice 3 subclases estaticas anidadas en main que  se extienden de AtributoOperacion
// y definen su propio cálculo basado en las claves.

public abstract class AtributoOperacion implements Atributo {

	// Claves de los atributos a comparar para calcular el valor:
	protected String key1;
	protected String key2;

	// Constructor:
	public AtributoOperacion(String key1, String key2) {
		super();
		this.key1 = key1;
		this.key2 = key2;
	}

	// Calcula el valor del atributo basado en los valores de `key1` y `key2` del
	// objeto Enfrentable dado. Cada tipo de AtributoOperacion tiene una lógica
	// específica para realizar este cálculo.

	@Override
	public float getValor(Enfrentable e) {
		// Obtiene los valores de los atributos asociados a key1 y key2
		float valor1 = e.getValorAtributo(key1);
		float valor2 = e.getValorAtributo(key2);

		// Esta parte es específica para cada atributo:

		if (this instanceof ResistenciaAtributo) {
			// Divide valor1 por valor2 si valor2 no es 0
			if (valor2 == 0) {
				return 0; // Retorna 0 , no se puede dividir por 0
			}
			return valor1 / valor2; // fuerza / velocidad
		}

		if (this instanceof CamuflajeAtributo) {
			// Retorna 50 si valor1 es mayor que valor2, sino retorna valor2
			return valor1 > valor2 ? 50 : valor2; // invisibilidad > fuerza
		}

		if (this instanceof ModernidadAtributo) {
			// Retorna el valor de edad si valor1 es mayor que valor2, sino 10
			return valor1 > valor2 ? e.getValorAtributo("edad") : 10;
		}

		// Retorna 0 si el tipo de atributo no coincide con ninguno esperado
		return 0;
	}
}