package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Recibirse")
public class Recibirse extends SuenioSimple {	
	
	@Transient
	private String carrera;
	
	public Recibirse()
	{
		super();
	}
	
	public Recibirse(Integer felicidonios, String carrera) {
		super(felicidonios);		
		this.carrera = carrera;
	}	
	
	public Integer getFelicidonios() {
		return felicidonios;
	}


	public void setFelicidonios(Integer felicidonios) {
		this.felicidonios = felicidonios;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public void validar(Persona persona)  {
		
		if (!persona.quiereEstudiarCarrera(carrera)) {
			throw new CarreraNoDeseadaException();			
		}	
		if (persona.terminoCarrera(carrera)) {
			throw new CarreraRealizadaException();				
		}
		
	}
	@Override
	public void realizar(Persona persona) {
		persona.recibirseCarrera(this.carrera);
		
	}
	@Override
	public Integer felicidonios() {		
		return this.felicidonios;
	}

	@Override
	public String toString() {
		return "Recibirse, felicidonios: " + felicidonios ;
	}	
	
}
