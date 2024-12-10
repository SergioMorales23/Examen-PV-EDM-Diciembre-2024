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

import ar.edu.unju.fi.enums.Nacionalidad;
import ar.edu.unju.fi.model.Pasajero;
import ar.edu.unju.fi.service.imp.PasajeroServiceImp;

@Controller
public class PasajeroController {
	
	@Autowired
	Pasajero nuevoPasajero;
	
	@Autowired
	PasajeroServiceImp pasajeroService;
	
	@GetMapping("/formularioPasajero")
	public ModelAndView getFormPasajero() {
		//vista formPasajero.html
		ModelAndView modelView = new ModelAndView("formPasajero");
		//agrega el objeto
		modelView.addObject("nuevoPasajero", nuevoPasajero );
	    List<Nacionalidad> nacionalidades = Arrays.asList(Nacionalidad.values());

		modelView.addObject("nacionalidades", nacionalidades);
		modelView.addObject("band", false);
		return modelView;
	}
	
	@GetMapping("/listadoDePasajeros")
	public ModelAndView getFormListaAlumno() {
		
		ModelAndView modelView = new ModelAndView("listaDePasajeros");
		modelView.addObject("listadoPasajeros", pasajeroService.listarPasajeros());	
		
		return modelView;	
	}
	
	
	@PostMapping("/guardarPasajero")
	public ModelAndView savePasajero(@ModelAttribute("nuevoPasajero") Pasajero pasajeroParaGuardar) {
					
		//guardar
		//ListadoCarreras.agregarCarrera(carreraParaGuardar);
		ModelAndView modelView = new ModelAndView("listaDePasajeros");			
		try {
				pasajeroService.guardarPasajero(pasajeroParaGuardar);	

		}catch(Exception e) {			
			modelView.addObject("errors", true);
			modelView.addObject("cargaPasajeroErrorMessage", "Error al cargar en la BD" + e.getMessage());
			System.out.println(e.getMessage());
		}
		
		modelView.addObject("listadoPasajeros", pasajeroService.listarPasajeros());				
		return modelView;		
	}
	
	
	 @GetMapping("/eliminarAlumno/{dni}")
	    public ModelAndView deletePasajeroDelListado(@PathVariable(name = "dni") String dni) {
		 
	        ModelAndView modelView = new ModelAndView("listaDePasajeros");
	        try {
	            pasajeroService.eliminarPasajero(dni);
	        } catch (Exception e) {
	            modelView.addObject("errors", true);
	            modelView.addObject("borrarAlumnoErrorMessage", "Error al borrar en la BD: " + e.getMessage());
	            System.out.println(e.getMessage());
	        }
	        modelView.addObject("listadoAlumnos", pasajeroService.listarPasajeros());
	        return modelView;
	    }
}
