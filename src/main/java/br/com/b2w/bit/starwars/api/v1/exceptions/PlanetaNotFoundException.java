package br.com.b2w.bit.starwars.api.v1.exceptions;

public class PlanetaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlanetaNotFoundException() {
	}

	public PlanetaNotFoundException(String message) {
		super(message);
	}

	public PlanetaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanetaNotFoundException(Throwable cause) {
		super(cause);
	}

	public PlanetaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
