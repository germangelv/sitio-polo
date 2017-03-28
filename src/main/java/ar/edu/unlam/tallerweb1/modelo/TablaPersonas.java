package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;

public class TablaPersonas {
	private static TablaPersonas instance = null;
	private List<Persona> listaPersonas = new LinkedList<Persona>();//Inicializacion del contenido para luego utilziarlo
	//La otra forma es inicializarlo en el constructo
	//El constructor no es un metodo ni un atributo sino un instanciador
	protected TablaPersonas(){
		//Exists only to defeact instantiation
		//Constructor Protected por SIngleton
		//Los constructores puedne recibir o no parametros
	}
	public static TablaPersonas getInstance(){ //static permite que se instancie sin necesidad de un new del mismo en la clase
		if(instance == null){
			instance = new TablaPersonas();
		}
		return instance;
	}
	public void crearPersona(Persona persona){
		this.listaPersonas.add(persona);		
	}
	public List<Persona> getPersonas(){
		return this.listaPersonas;
	}
}
