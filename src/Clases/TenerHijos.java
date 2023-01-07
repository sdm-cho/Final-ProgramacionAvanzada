package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Tener Hijo/s")
public class TenerHijos extends SuenioSimple {	
	
	@Transient
	private Integer hijosATener;
	
	public TenerHijos()
	{
		super();
	}
	
	
	public TenerHijos(Integer felicidonios, Integer hijosATener) {
		super(felicidonios);		
		this.hijosATener = hijosATener;
	}	
	
	public Integer getFelicidonios() {
		return felicidonios;
	}

	public void setFelicidonios(Integer felicidonios) {
		this.felicidonios = felicidonios;
	}


	public Integer getHijosATener() {
		return hijosATener;
	}


	public void setHijosATener(Integer hijosATener) {
		this.hijosATener = hijosATener;
	}


	@Override
	public void realizar(Persona persona) {
		persona.tenerHijo(this.hijosATener);		
	}
	@Override
	public Integer felicidonios() {		
		return this.felicidonios;
	}	
	@Override
	public String toString() {
		return "Tener Hijos, felicidonios: " + felicidonios ;
	}	
	
	
}


