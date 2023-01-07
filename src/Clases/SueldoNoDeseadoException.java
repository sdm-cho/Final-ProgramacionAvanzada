package Clases;

public class SueldoNoDeseadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public SueldoNoDeseadoException() {
		super("La persona desea un sueldo mas alto");
		
     }
	

}
