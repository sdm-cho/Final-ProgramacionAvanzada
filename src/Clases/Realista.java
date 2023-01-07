package Clases;

import java.util.Comparator;
import java.util.List;

public class Realista implements tipoPersona {

	@Override
	public Suenio elegirSuenio(List<Suenio> sueniosPendientes) {		
		return sueniosPendientes.stream().max(Comparator.comparing(Suenio::felicidonios)).get();
	}
	

}
