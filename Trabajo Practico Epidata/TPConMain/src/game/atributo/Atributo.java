package game.atributo;

import game.Enfrentable;

// Esta es la interfaz que define un atributo en el juego.
// Implementa un único método getValor, que permite obtener el valor
// del atributo en función de un objeto Enfrentable.
public interface Atributo {
	
	// Tres diferentes clases van a implementar luego este método.
	float getValor(Enfrentable e);

}
