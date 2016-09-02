package fr.pizzeria.exception;

public class DebitException extends RuntimeException {

	private static final String MSG = "Montant inf�rieur a 0 euro pour ce d�bit vous ne pouvez pas d�biter ce compte ou choisiez un nouveau montant !\n";

	public DebitException() {
		super(MSG);
		// TODO Auto-generated constructor stub
	}

	public DebitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DebitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DebitException(Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}
}
