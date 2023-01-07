package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Viajar")
public class Viajar extends SuenioSimple {	
	
	@Transient
	private String destino;
	
	public Viajar()
	{
		super();
	}
		
	public Viajar(Integer felicidonios, String destino) {
		super(felicidonios);		
		this.destino = destino;
	}

	
	public Integer getFelicidonios() {
		return felicidonios;
	}


	public void setFelicidonios(int felicidonios) {
		this.felicidonios = felicidonios;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	@Override
	public void realizar(Persona persona) {
		persona.viajarA(this.destino);	
	}

	@Override
	public Integer felicidonios() {		
		return this.felicidonios;
	}

	@Override
	public void validar(Persona persona) {
				
	}
	@Override
	public String toString() {
		return "Viajar, felicidonios: " + felicidonios ;
	}	
	
}
