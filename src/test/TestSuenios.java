package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Clases.Persona;
import Clases.AdoptarHijoException;
import Clases.AdoptarHijos;
import Clases.Recibirse;
import Clases.SueldoNoDeseadoException;
import Clases.SuenioMultiple;
import Clases.SuenioNoPendienteException;
import Clases.TenerHijos;
import Clases.Trabajar;
import Clases.Viajar;
import Clases.Alocado;
import Clases.CarreraNoDeseadaException;
import Clases.CarreraRealizadaException;
import Clases.Obsesivo;
import Clases.Realista;

@SuppressWarnings("unused")
public class TestSuenios
{
	AdoptarHijos adoptar2Hijos;
	Recibirse recibirseDeLicenciadoEnSistemas;
	TenerHijos tener2Hijos;
	TenerHijos tener1Hijo;
	Viajar viajarABrasil;
	Viajar viajarACataratas;
	Viajar viajarAChapadmalal;
	Trabajar trabajarProgramador;
	Trabajar trabajarOficinista;
	SuenioMultiple suenioMultiple;
	Persona pedro;
	Persona juan;
	Persona pablo;

	@Before
	public void setUp() throws Exception
	{
		adoptar2Hijos=new AdoptarHijos(100,2);
		recibirseDeLicenciadoEnSistemas=new Recibirse(50,"Licenciado en sistemas");
		tener2Hijos=new TenerHijos(150,2);
		viajarABrasil=new Viajar(90,"Brasil");
		viajarAChapadmalal=new Viajar(110,"Chapadmalal");
		trabajarProgramador=new Trabajar(70,80000);
		viajarACataratas=new Viajar(80,"Cataratas");
		tener1Hijo=new TenerHijos(140,1);
		trabajarOficinista=new Trabajar(70,10000);
		suenioMultiple=new SuenioMultiple(1000 , Arrays.asList(viajarACataratas,tener1Hijo,trabajarOficinista));
		
		

		pedro=new Persona("Pedro",Arrays.asList(adoptar2Hijos,viajarAChapadmalal,recibirseDeLicenciadoEnSistemas),10,new Alocado());
		juan=new Persona("Juan",Arrays.asList(tener2Hijos,viajarABrasil,suenioMultiple),100,new Realista());
		pablo=new Persona("Pablo",Arrays.asList(trabajarProgramador,viajarABrasil,tener2Hijos,adoptar2Hijos),200,new Obsesivo());
		
	}

	/*SUEÑOS*/
	@Test
	public void testTener1HijoEsAmbicioso()
	{
		assertTrue(tener1Hijo.esAmbicioso());
	}
	
	@Test
	public void testViajarACataratasNoEsAmbicioso()
	{
		assertFalse(viajarACataratas.esAmbicioso());
	}
	/*
	 * PEDRO
	 */
	
	public void pedroCumpliSuenios()
	{
		pedro.setCarrerasAEstudiar(Arrays.asList("Licenciado en sistemas"));
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
		pedro.cumplir(viajarAChapadmalal);
		pedro.cumplir(adoptar2Hijos);
	}
	
	@Test
	public void testPedroSeRecibeDeLicenciadoEnSistemas()
	{
		pedro.setCarrerasAEstudiar(Arrays.asList("Licenciado en sistemas"));
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
		assertEquals(60,pedro.getFelicidonios(), 0.001);
		assertTrue(pedro.getCarrerasTerminadas().contains("Licenciado en sistemas"));
		assertTrue(recibirseDeLicenciadoEnSistemas.getCumplido());
	}
	
	@Test(expected=CarreraRealizadaException.class ) 
	public void testPedroYaEstaRecibidoDeLicenciadoEnSistemas() {
		pedro.setCarrerasAEstudiar(Arrays.asList("Licenciado en sistemas"));
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
		recibirseDeLicenciadoEnSistemas.setCumplido(false);		
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
	}
	
	

	@Test(expected=SuenioNoPendienteException.class)
	public void testPedroNoPuedeCumplirViajarABrasil() 
	{
		pedro.cumplir(viajarABrasil);
	}

	@Test
	public void testPedroCumpleCualquierSueño()
	{
		pedro.cumplirSuenioElegido();
		assertEquals(110,pedro.getFelicidonios(), 0.001);
		assertTrue(pedro.getSuenios().stream().anyMatch(s -> !s.estaPendiente(pedro)));
	}
	
	@Test
	public void testPedroEsAmbiciosa()
	{
		pedroCumpliSuenios();
		assertFalse(pedro.esAmbiciosa());
	}
	
	@Test
	public void testPedroEsFeliz()
	{
		pedroCumpliSuenios();
		assertTrue(pedro.esFeliz());
	}

	/*
	 * JUAN
	 */

	@Test
	public void testJuanViajaABrasil()
	{
		juan.cumplir(viajarABrasil);
		assertEquals(190,juan.getFelicidonios(), 0.001);
		assertTrue(juan.getLugaresVisitados().contains("Brasil"));
	}

	@Test(expected=SueldoNoDeseadoException.class)
    public void testJuanNoPuedeCumplirSuenioMultiple() 
    {
        juan.setSueldoDeseado(11000);
        juan.cumplir(suenioMultiple);
    }
	
	@Test(expected=SuenioNoPendienteException.class)
	public void testJuanNoEstudiaAlgoQueNoQuiere() 
	{
		juan.setCarrerasAEstudiar(Arrays.asList("Medicina"));		
		juan.cumplir(recibirseDeLicenciadoEnSistemas);
	}

	@Test
	public void testJuanCumpleElMayorSueño()
	{
		juan.setSueldoDeseado(10000);
		juan.cumplirSuenioElegido();
		assertEquals(1,juan.getCantidadHijos(), 0.001);
		assertEquals(390,juan.getFelicidonios(), 0.001);
		assertFalse(tener1Hijo.getCumplido());
		assertTrue(suenioMultiple.getCumplido());
		assertEquals(290, suenioMultiple.felicidonios(), 0.001);
	}

	/*
	 * PABLO
	 */

	@Test
	public void testPabloViajaABrasil()
	{
		pablo.cumplir(viajarABrasil);
		assertEquals(290,pablo.getFelicidonios(), 0.001);
		assertTrue(pablo.getLugaresVisitados().contains("Brasil"));
	}

	@Test(expected=AdoptarHijoException.class)
	public void testPabloNoAdoptarHijosLuegoDeTenerlos()
	{
		pablo.cumplir(tener2Hijos);
		pablo.cumplir(adoptar2Hijos);
	}
	
	@Test(expected=SueldoNoDeseadoException.class)
	public void testPabloNoAceptaTrabajarDeProgramador()
	{
		pablo.setSueldoDeseado(100000);
		pablo.cumplir(trabajarProgramador);
	}

	@Test
	public void testPabloCumpleElPrimeroSueño()
	{
		pablo.setSueldoDeseado(70000);		
		pablo.cumplirSuenioElegido();
		
		assertEquals(270,pablo.getFelicidonios(), 0.001);	
		assertFalse(pablo.getSueldoDeseado().compareTo(80000) == 0);
		assertTrue(trabajarProgramador.getCumplido());
	}

}
