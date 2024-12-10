package ar.edu.unju.fi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Habitacion;
import ar.edu.unju.fi.model.Pasajero;
import ar.edu.unju.fi.model.Reserva;
import ar.edu.unju.fi.service.imp.HabitacionServiceImp;
import ar.edu.unju.fi.service.imp.PasajeroServiceImp;
import ar.edu.unju.fi.service.imp.ReservaServiceImp;


@Controller
public class ReservaController {
	
	
	@Autowired
	Reserva nuevoReserva;
	
	@Autowired
	ReservaServiceImp reservaService;
	
	@Autowired 
	PasajeroServiceImp pasajeroService;
	
	@Autowired
	HabitacionServiceImp habitacionService;
	
	@GetMapping("/formularioReserva")
	public ModelAndView getFormReserva() {
		//vista formPasajero.html
		ModelAndView modelView = new ModelAndView("formReserva");
		//agrega el objeto
		modelView.addObject("nuevoReserva", nuevoReserva );
		List<Pasajero> pasajeros = pasajeroService.listarPasajeros();
		
		modelView.addObject("pasajeros", pasajeros);
		
		List<Habitacion> habitaciones = habitacionService.listarHabitaciones();
		modelView.addObject("habitaciones", habitaciones);
		
		modelView.addObject("band", false);
		return modelView;
	}
	
	@GetMapping("/listadoDeReservas")
	public ModelAndView getFormListaAlumno() {
		
		ModelAndView modelView = new ModelAndView("listaDeReservas");
		modelView.addObject("listadoReservas", reservaService.listarReservas());	
		
		return modelView;	
	}
	
	
	@PostMapping("/guardarReserva")
	public ModelAndView saveReserva(@ModelAttribute("nuevoReserva") Reserva reservaParaGuardar, BindingResult bindingResult) {
	    ModelAndView modelView = new ModelAndView("listaDeReservas");
	    
	    // Verificar si la habitación está disponible
	    boolean isAvailable = reservaService.isHabitacionDisponible(reservaParaGuardar.getHabitacion().getCodigo(), reservaParaGuardar.getFecha());
	    
	    if (!isAvailable) {
	        bindingResult.rejectValue("habitacion", "error.habitacion", "La habitación ya está reservada para esta fecha.");
	    }
	    
	    // Validar el objeto
	    if (bindingResult.hasErrors()) {
	        // Si hay errores, volver a mostrar el formulario
	        modelView.setViewName("formReserva");
	        modelView.addObject("nuevoReserva", reservaParaGuardar);
	        return modelView;
	    }
	    
	    try {
	        reservaService.guardarReserva(reservaParaGuardar);
	    } catch (Exception e) {
	        modelView.addObject("errors", true);
	        modelView.addObject("cargaReservaErrorMessage", "Error al cargar en la BD: " + e.getMessage());
	        System.out.println(e.getMessage());
	    }
	    
	    modelView.addObject("listadoReservas", reservaService.listarReservas());
	    return modelView;
	}
	
	
	 @GetMapping("/eliminarReserva/{codigo}")
	    public ModelAndView deleteReservaDelListado(@PathVariable(name = "codigo") long codigo) {
		 
	        ModelAndView modelView = new ModelAndView("listaDeReservas");
	        try {
	            reservaService.eliminarReserva(codigo);
	        } catch (Exception e) {
	            modelView.addObject("errors", true);
	            modelView.addObject("borrarReservaErrorMessage", "Error al borrar en la BD: " + e.getMessage());
	            System.out.println(e.getMessage());
	        }
	        modelView.addObject("listadoReservas", reservaService.listarReservas());
	        return modelView;
	    }
}