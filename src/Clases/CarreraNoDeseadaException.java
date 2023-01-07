package Clases;

public class CarreraNoDeseadaException extends RuntimeException{	
		
		private static final long serialVersionUID = 1L;

		public CarreraNoDeseadaException() {
			super("La persona no quiere estudiar la carrera");			
	     }	

}
