package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("unused")

public class Persona {
	private List<Suenio> suenios;
	private String nombre;	
	private int edad;	
	private Integer felicidonios;	
	private List<String> lugaresVisitados = new ArrayList<String>();	
	private List<String> carrerasTerminadas = new ArrayList<String>();	
	private List<String> carrerasAEstudiar = new ArrayList<String>();	
	private List<Integer> sueldoNuevo = new ArrayList<Integer>();		
	private Integer cantidadHijos = 0;		
	private Integer sueldoDeseado;		
	private tipoPersona tipoPersona;
	
	public Persona() {
		super();
	}
	
	public Persona(List<Suenio> suenios) {
		super();
		this.suenios = suenios;
	}
		
	
	public Persona(String nombre, List<Suenio> suenios, int edad) {
		super();		
		this.nombre = nombre;
		this.suenios = suenios;
		this.edad = edad;
	}
	
	public Persona(Integer felicidonios, List<Suenio> suenios, List<String> lugaresVisitados,
			List<String> carrerasTerminadas, List<String> carrerasAEstudiar, List<Integer> sueldoNuevo,
			Integer cantidadHijos, Integer sueldoDeseado, Integer nuevoSueldo, Clases.tipoPersona tipoPersona,
			String nombre) {
		super();
		this.felicidonios = felicidonios;
		this.suenios = suenios;
		this.lugaresVisitados = lugaresVisitados;
		this.carrerasTerminadas = carrerasTerminadas;
		this.carrerasAEstudiar = carrerasAEstudiar;
		this.sueldoNuevo = sueldoNuevo;
		this.cantidadHijos = cantidadHijos;
		this.sueldoDeseado = sueldoDeseado;		
		this.tipoPersona = tipoPersona;
		this.nombre = nombre;
	}	

	public Persona(String nombre, List<Suenio> suenios,Integer felicidonios, Clases.tipoPersona tipoPersona) {
		super();
		this.nombre = nombre;
		this.suenios = suenios;
		this.felicidonios = felicidonios;	
		this.tipoPersona = tipoPersona;
	}
	
	public void cumplir(Suenio suenio) {
		if (!sueniosPendientes().contains(suenio)) {
			throw new SuenioNoPendienteException();
		}
		suenio.cumplir(this);
	}
	
	private List<Suenio> sueniosPendientes()
	{
		return suenios.stream().filter(suenio->suenio.estaPendiente(this)).collect(Collectors.toList());
	}
	
	public void sumarFelicidad(Integer felicidonios) 
	{
		this.felicidonios+=felicidonios;
	}
	
	public boolean tieneHijos() {
		return this.cantidadHijos > 0;		
	}
	
	public void agregarHijos(Integer hijosAAdoptar) {
		this.cantidadHijos+=hijosAAdoptar;
	}	
	
	public void cumplirSuenioElegido() {
		Suenio suenioElegido = tipoPersona.elegirSuenio(sueniosPendientes());
		cumplir(suenioElegido);
	}

	public void viajarA(String destino) {
		this.lugaresVisitados.add(destino);		
	}

	public boolean quiereEstudiarCarrera(String carrera) {
		return carrerasAEstudiar.contains(carrera);
	}

	public boolean terminoCarrera(String carrera) {			
		return carrerasTerminadas.contains(carrera);
	}

	public void recibirseCarrera(String carrera) {
		this.carrerasTerminadas.add(carrera);			
	}

	public boolean sueldoInsuficiente(Integer sueldo) {		
		return this.sueldoDeseado > sueldo;
	}	

	public void tenerHijo(Integer hijosATener) {
		this.cantidadHijos += hijosATener;		
	}

	public void nuevoSueldo(Integer sueldo) {
		this.sueldoNuevo.add(sueldo);
	}	
	
	public boolean esFeliz() {
		return this.felicidonios > sueniosPendientes().stream().mapToInt(suenio->suenio.felicidonios()).sum();
	}
	
	public List<Integer> getSueldoNuevo() {
		return sueldoNuevo;
	}

	public void setSueldoNuevo(List<Integer> sueldoNuevo) {
		this.sueldoNuevo = sueldoNuevo;
	}
	
	public List<Suenio> sueniosAmbiciosos()
	{
		return suenios.stream().filter(suenio->suenio.esAmbicioso()).collect(Collectors.toList());
	}
	
	public boolean esAmbiciosa() 
	{
		return this.sueniosAmbiciosos().size() > 3;
	}

	@Override
	public String toString() {
		return "Persona [felicidonios=" + felicidonios + ", suenios=" + suenios + ", lugaresVisitados="
				+ lugaresVisitados + ", carrerasTerminadas=" + carrerasTerminadas + ", carrerasAEstudiar="
				+ carrerasAEstudiar + ", cantidadHijos=" + cantidadHijos + ", sueldoDeseado=" + sueldoDeseado
				+ ", tipoPersona=" + tipoPersona + "]";
	}

	public Integer getFelicidonios() {
		return felicidonios;
	}

	public void setFelicidonios(Integer felicidonios) {
		this.felicidonios = felicidonios;
	}

	public List<Suenio> getSuenios() {
		return suenios;
	}

	public void setSuenios(List<Suenio> suenios) {
		this.suenios = suenios;
	}

	public List<String> getLugaresVisitados() {
		return lugaresVisitados;
	}

	public void setLugaresVisitados(List<String> lugaresVisitados) {
		this.lugaresVisitados = lugaresVisitados;
	}

	public List<String> getCarrerasTerminadas() {
		return carrerasTerminadas;
	}

	public void setCarrerasTerminadas(List<String> carrerasTerminadas) {
		this.carrerasTerminadas = carrerasTerminadas;
	}

	public List<String> getCarrerasAEstudiar() {
		return carrerasAEstudiar;
	}

	public void setCarrerasAEstudiar(List<String> carrerasAEstudiar) {
		this.carrerasAEstudiar = carrerasAEstudiar;
	}

	public Integer getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(Integer cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public Integer getSueldoDeseado() {
		return sueldoDeseado;
	}

	public void setSueldoDeseado(Integer sueldoDeseado) {
		this.sueldoDeseado = sueldoDeseado;
	}

	public tipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(tipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}		

}
