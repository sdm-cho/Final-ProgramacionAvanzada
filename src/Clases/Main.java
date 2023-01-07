package Clases;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String[] args) {		
		
		AdoptarHijos adoptar2Hijos = new AdoptarHijos(100,2);		
		Recibirse recibirseDeLicenciadoEnSistemas=new Recibirse(50,"Licenciado en sistemas");
		TenerHijos tener2Hijos=new TenerHijos(150,2);
		Viajar viajarABrasil=new Viajar(90,"Brasil");
		Viajar viajarAChapadmalal=new Viajar(110,"Chapadmalal");
		Trabajar trabajarProgramador=new Trabajar(70,80000);
		Viajar viajarACataratas=new Viajar(80,"Cataratas");
		TenerHijos tener1Hijo=new TenerHijos(140,1);
		Trabajar trabajarOficinista=new Trabajar(70,10000);
		Recibirse recibirseDeAdministradorDeEmpresas = new Recibirse(45, "Administracion de Empresas");
		Trabajar corredorDeBolsa = new Trabajar(60, 40000);
		SuenioMultiple suenioMultiple = new SuenioMultiple(1000 , Arrays.asList(viajarACataratas,tener1Hijo,trabajarOficinista));
				
		
		guardar(adoptar2Hijos);
		guardar(recibirseDeLicenciadoEnSistemas);
		guardar(tener2Hijos);	
		guardar(viajarABrasil);
		guardar(viajarAChapadmalal);
		guardar(trabajarProgramador);
		guardar(viajarACataratas);		
		guardar(tener1Hijo);
		guardar(trabajarOficinista);
		guardar(recibirseDeAdministradorDeEmpresas);
		guardar(corredorDeBolsa);
		guardar(suenioMultiple);		
		
		Suenio s = encontrarSuenioPorId(1L);
		System.out.println(s.toString());
	}
	
	private static void guardar(Suenio suenios) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(suenios);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}	

	  } 	
	
	
	private static Suenio encontrarSuenioPorId(Long suenioId) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Suenio s = em.find(Suenio.class, suenioId);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
	

}



