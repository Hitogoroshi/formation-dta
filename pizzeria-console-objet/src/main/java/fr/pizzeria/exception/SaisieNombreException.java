package fr.pizzeria.exception;

public class SaisieNombreException extends Exception {

	private static final String MSG = "Veuillez saisir un nombre !";

	public SaisieNombreException() {
		super(MSG);
		// TODO Auto-generated constructor stub
	}

	public SaisieNombreException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SaisieNombreException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SaisieNombreException(Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}

}
