package Clases;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
@Entity
@DiscriminatorValue("Suenio Multiple")
public class SuenioMultiple extends Suenio {	
   @Transient
	private List<Suenio> suenios; 
	
	@Transient
	private Integer felicidonios;
	
	
	public SuenioMultiple() {
		super();
	}
	
	
	public SuenioMultiple(Integer felicidonios, List<Suenio> suenios) {
		super();
		this.felicidonios = felicidonios;
		this.suenios = suenios;
	}

	public int getFelicidonios() {
		return felicidonios;
	}

	public void setFelicidonios(int felicidonios) {
		this.felicidonios = felicidonios;
	}

	public List<Suenio> getSuenios() {
		return suenios;
	}

	public void setSuenios(List<Suenio> suenios) {
		this.suenios = suenios;
	}

	@Override
	public Integer felicidonios() {		
		return suenios.stream().mapToInt(suenio -> suenio.felicidonios()).sum();
	}

	@Override
	public void validar(Persona persona) {
		suenios.forEach(suenio -> suenio.validar(persona));
		
	}

	@Override
	public void realizar(Persona persona) {
		suenios.forEach(suenio -> suenio.realizar(persona));
		
	}	
	
	public void setFelicidonios(Integer felicidonios) {
		this.felicidonios = felicidonios;
	}
	
	/*public int getSuenioMultipleId() {
		return suenioMultipleId;
	}
	public void setSuenioMultipleId(int suenioMultipleId) {
		this.suenioMultipleId = suenioMultipleId;
	}	*/
	

}
