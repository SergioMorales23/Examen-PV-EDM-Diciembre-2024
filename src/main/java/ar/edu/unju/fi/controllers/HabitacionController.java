package ar.edu.unju.fi.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.enums.Tipo;
import ar.edu.unju.fi.model.Habitacion;
import ar.edu.unju.fi.service.imp.HabitacionServiceImp;

@Controller
public class HabitacionController {
	@Autowired
	Habitacion nuevoHabitacion;
	
	@Autowired
	HabitacionServiceImp habitacionService;
	
	@GetMapping("/formularioHabitacion")
	public ModelAndView getFormHabitacion() {
		//vista formPasajero.html
		ModelAndView modelView = new ModelAndView("formHabitacion");
		//agrega el objeto
		modelView.addObject("nuevoHabitacion", nuevoHabitacion );
	    List<Tipo> tipos = Arrays.asList(Tipo.values());

		modelView.addObject("tipos", tipos);
		modelView.addObject("band", false);
		return modelView;
	}
	
	@GetMapping("/listadoDeHabitaciones")
	public ModelAndView getFormListaAlumno() {
		
		ModelAndView modelView = new ModelAndView("listaDeHabitaciones");
		modelView.addObject("listadoHabitaciones", habitacionService.listarHabitaciones());	
		
		return modelView;	
	}
	
	
	@PostMapping("/guardarHabitacion")
	public ModelAndView saveHabitacion(@ModelAttribute("nuevoHabitacion") Habitacion habitacionParaGuardar) {
					
		//guardar
		//ListadoCarreras.agregarCarrera(carreraParaGuardar);
		ModelAndView modelView = new ModelAndView("listaDeHabitaciones");			
		try {
				habitacionService.guardarHabitacion(habitacionParaGuardar);	

		}catch(Exception e) {			
			modelView.addObject("errors", true);
			modelView.addObject("cargaHabitacionErrorMessage", "Error al cargar en la BD: " + e.getMessage());
			System.out.println(e.getMessage());
		}
		
		modelView.addObject("listadoHabitaciones", habitacionService.listarHabitaciones());				
		return modelView;		
	}
	
	
	 @GetMapping("/eliminarHabitacion/{codigo}")
	    public ModelAndView deleteHabitacionDelListado(@PathVariable(name = "codigo") long codigo) {
		 
	        ModelAndView modelView = new ModelAndView("listaDeHabitaciones");
	        try {
	            habitacionService.eliminarHabitacion(codigo);
	        } catch (Exception e) {
	            modelView.addObject("errors", true);
	            modelView.addObject("borrarHabitacionErrorMessage", "Error al borrar en la BD: " + e.getMessage());
	            System.out.println(e.getMessage());
	        }
	        modelView.addObject("listadoHabitaciones", habitacionService.listarHabitaciones());
	        return modelView;
	    }
}
