package Clases;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SUENIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="suenios", 
discriminatorType = DiscriminatorType.STRING)

public abstract class Suenio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long suenioId;

	@Column(name = "felicidonios")
	protected Integer felicidonios;
	@Transient
	private Boolean cumplido = false;

	@Transient
	public abstract Integer felicidonios();

	@Transient
	public abstract void validar(Persona persona);

	@Transient
	public abstract void realizar(Persona persona);
	
	public Suenio() {
		super();
	}
	public Suenio(Integer felicidonios) {
		this.felicidonios = felicidonios;
		this.cumplido = false;		
	}

	public Boolean estaPendiente(Persona persona) {
		return !cumplido;
	}

	public void cumplir(Persona Persona) {
		validar(Persona);
		realizar(Persona);
		cumplir();
		Persona.sumarFelicidad(this.felicidonios());
	}

	public Boolean getCumplido() {
		return cumplido;
	}

	public void setCumplido(Boolean cumplido) {
		this.cumplido = cumplido;
	}

	private void cumplir() {

		setCumplido(true);
	}

	public boolean esAmbicioso() {
		return this.felicidonios() > 100;
	}

}