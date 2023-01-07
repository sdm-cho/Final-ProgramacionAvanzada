package Clases;

import java.util.List;

import javax.persistence.Entity;


@Entity
public class SuenioSimple extends Suenio {	
	
	
	public SuenioSimple() {
		super();
	}	
	public SuenioSimple(Integer felicidonios) {
		super(felicidonios);
	}
	
	@Override
	public Integer felicidonios() {		
		return this.felicidonios;
	}

	@Override
	public void validar(Persona persona) {		
	}

	@Override
	public void realizar(Persona persona) {		
	}
	
	

}
