package Clases;

public class SuenioNoPendienteException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuenioNoPendienteException() {
		super("La persona no tiene este sueño pendiente");
		
     }
	
}