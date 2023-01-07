package Clases;

import java.util.List;

public class Alocado implements tipoPersona 
{

	@Override
	public Suenio elegirSuenio(List<Suenio> sueniosPendientes) {
		return sueniosPendientes.stream().findAny().get();
		
	}

}
