package Clases;

import java.util.List;

public class Obsesivo implements tipoPersona {

	@Override
	public Suenio elegirSuenio(List<Suenio> sueniosPendientes) {
		return sueniosPendientes.stream().findFirst().get();		
	}
}
