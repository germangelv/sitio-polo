package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.TablaPersonas;

/*
 * Es la accion de un controlador que frente a /hola muestra la Vista Saludo
 */

/*
@Controller
public class MiPrimerControlador {
	
	@RequestMapping (path="/hola")
	public ModelAndView Pruebita (){
		
		ModelAndView var = new ModelAndView ("Saludo");
		
		return var;
	}
	 
}
*/

@Controller
public class MiPrimerControlador {
	/*
	 * hola/variable
	 */
	@RequestMapping (path="nombre/{nombre}/apellido/{apellido}")
	//public ModelAndView Pruebita (@PathVariable String nombre, String apellido){
	
	
	/*
	 * Utilziacion de PathVariable
	 * 
	 */
	public ModelAndView Pruebita (@PathVariable String nombre, @PathVariable String apellido){
		
		ModelAndView var = new ModelAndView ("Saludo");
		
		ModelMap model = new ModelMap(); //Creo un mapa y guardo un dato
		model.put ("key1", nombre);
		model.put("key2", apellido);
		System.out.println(nombre+" "+apellido);
		
		//Con esto mando a la Vista un mapa con valores
		return new ModelAndView ("Saludo", model);
	}
	
	/*
	 * API conjunto de funcionalidades expuestas
	 * API Rest porque usa un protocolo particular
	 * Por ejemplo un conjunto de URL
	 * CEO (Preetty URL)
	 */
	@RequestMapping (path="/hola", method = RequestMethod.GET) 
	///hola?nombre=Sebastian&apellido=Ismael
	public ModelAndView Pruebita2 (@RequestParam ("nombre") String nombre,
								   @RequestParam ("apellido") String apellido){
		ModelMap model = new ModelMap();
		model.put ("key1", nombre);
		model.put("key2", apellido);
		System.out.println(nombre+" "+apellido);
								//Nombre de Vista y Modelo correspondiente
		return new ModelAndView ("Saludo", model); 
		
	}
	
	@RequestMapping (path="/lista", method = RequestMethod.GET)
	public ModelAndView verLista (){
		ModelMap miMapa = new ModelMap(); //Como antes
		List<Persona> listaDePersonas = TablaPersonas.getInstance().getPersonas();
		miMapa.put("lista", listaDePersonas);
		ModelAndView miVistaDePersonas = new ModelAndView();
		miVistaDePersonas.addAllObjects(miMapa);
		miVistaDePersonas.setViewName("lista");
		return miVistaDePersonas;
	}
	 
	@RequestMapping (path="/formulario", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario(){
		ModelMap miMapa = new ModelMap();
		Persona p1 = new Persona();
		//p1.setNombre("Juan"); no necesario crar una para cargar
		//p1.setApellido("Perez");
		miMapa.put("persona", p1);
		return new ModelAndView ("formulario", miMapa);		
	}
	
	@RequestMapping (path="/confirmacion", method = RequestMethod.POST)
	public ModelAndView agregarContacto(@ModelAttribute("persona") Persona persona){
		ModelMap miModelo = new ModelMap();
		
		miModelo.put("nombre", persona.getNombre());
		miModelo.put("apellido",persona.getApellido());
		miModelo.put("persona",persona);
			
		return new ModelAndView("confirmacion", miModelo);
	}
	
	@RequestMapping (path="/lista", method = RequestMethod.POST)
	public String almacenarContacto (@ModelAttribute("persona") Persona persona){
		TablaPersonas listaParaAlmacenar = TablaPersonas.getInstance();
		listaParaAlmacenar.crearPersona(persona);
		return "redirect:/lista";
	}
}
