package fr.pizzeria.exception;

public class CreditException extends RuntimeException {

	private static final String MSG = "Votre solde ne peut exceder 5000 euro !\n";

	public CreditException() {
		super(MSG);
		// TODO Auto-generated constructor stub
	}

	public CreditException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CreditException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CreditException(Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}

}
