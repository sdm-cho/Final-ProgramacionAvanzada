package Clases;

public class CarreraRealizadaException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarreraRealizadaException() {
		super("La persona ya termino esta carrera");
     }
	
}