package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Trabajar")
public class Trabajar extends SuenioSimple 
{
	
	@Transient
	private Integer sueldo;	
	
	public Trabajar()
	{
		super();
	}
	
	public Trabajar(Integer felicidonios, Integer sueldo) {
		super(felicidonios);		
		this.sueldo = sueldo;
	}
	public Integer getFelicidonios() {
		return felicidonios;
	}
	public void setFelicidonios(Integer felicidonios) {
		this.felicidonios = felicidonios;
	}
	public Integer getSueldo() {
		return sueldo;
	}
	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public void validar(Persona persona) {	
		if(persona.sueldoInsuficiente(sueldo)) {
			throw new SueldoNoDeseadoException();	
		}				
	}	
	@Override
	public void realizar(Persona persona) {
		persona.nuevoSueldo(this.sueldo);				
	}	
	
	@Override
	public Integer felicidonios() {		
		return this.felicidonios;
	}
	@Override
	public String toString() {
		return "Trabajar, felicidonios: " + felicidonios ;
	}	

}
