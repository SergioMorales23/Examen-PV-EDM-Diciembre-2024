package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Habitacion;
import ar.edu.unju.fi.repository.HabitacionRepository;
import ar.edu.unju.fi.service.IHabitacionService;

@Service
public class HabitacionServiceImp implements IHabitacionService {

	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Override
	public void guardarHabitacion (Habitacion habitacion) {
		habitacion.setEstado(true);
		habitacionRepository.save(habitacion);
		
	}

	@Override
	public List<Habitacion> listarHabitaciones() {
		// TODO Auto-generated method stub
		return habitacionRepository.findHabitacionByEstado(true);
	}

	@Override
	public void eliminarHabitacion(long codigo) {
		// TODO Auto-generated method stub
		List<Habitacion> todosLosHabitaciones = habitacionRepository.findAll();
		for (int i = 0; i < todosLosHabitaciones.size(); i++) {
		      Habitacion habitacion = todosLosHabitaciones.get(i);
		      if (habitacion.getCodigo() == codigo) {
		        habitacion.setEstado(false);
		        habitacionRepository.save(habitacion);
		        break;
		      }
		    }
	}
}
