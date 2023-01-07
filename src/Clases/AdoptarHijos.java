package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Adoptar Hijos")
public class AdoptarHijos extends SuenioSimple {
			
		
	@Transient
	private Integer hijosAAdoptar;
	
	public AdoptarHijos()
	{
		super();
	}
	public AdoptarHijos(Integer felicidonios, Integer hijosAAdoptar) {
		super(felicidonios);		
		this.hijosAAdoptar = hijosAAdoptar;
	}	
	
	public Integer getFelicidonios() {
		return felicidonios;
	}


	public void setFelicidonios(Integer felicidonios) {
		this.felicidonios = felicidonios;
	}


	public Integer getHijosAAdoptar() {
		return hijosAAdoptar;
	}


	public void setHijosAAdoptar(Integer hijosAAdoptar) {
		this.hijosAAdoptar = hijosAAdoptar;
	}

	@Override
	public void validar(Persona persona) {
		if (persona.tieneHijos()) {
			throw new AdoptarHijoException();			
		}		
	}
	@Override
	public void realizar(Persona persona) {
		persona.agregarHijos(this.hijosAAdoptar);
		
	}
	@Override
	public Integer felicidonios() {		
		return this.felicidonios;
	}
	@Override
	public String toString() {
		return "Adoptar Hijos, felicidonios: " + felicidonios ;
	}	
		
}
