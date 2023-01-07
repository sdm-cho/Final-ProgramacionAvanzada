package Clases;

public class AdoptarHijoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AdoptarHijoException() {
		super("Esta persona ya tiene un hijo, no puede adoptar");		
     }

}
