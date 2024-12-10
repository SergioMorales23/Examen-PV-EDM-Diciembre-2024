package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Pasajero;
import ar.edu.unju.fi.repository.PasajeroRepository;
import ar.edu.unju.fi.service.IPasajeroService;

@Service
public class PasajeroServiceImp implements IPasajeroService {

	@Autowired
	PasajeroRepository pasajeroRepository;
	
	@Override
	public void guardarPasajero (Pasajero pasajero) {
		pasajero.setEstado(true);
		pasajeroRepository.save(pasajero);
		
	}

	@Override
	public List<Pasajero> listarPasajeros() {
		// TODO Auto-generated method stub
		//return alumnoRepository.findAll();
		return pasajeroRepository.findPasajeroByEstado(true);
	}

	@Override
	public void eliminarPasajero(String dni) {
		// TODO Auto-generated method stub
		List<Pasajero> todosLosPasajeros = pasajeroRepository.findAll();
		for (int i = 0; i < todosLosPasajeros.size(); i++) {
		      Pasajero pasajero = todosLosPasajeros.get(i);
		      if (pasajero.getDni().equals(dni)) {
		        pasajero.setEstado(false);
		        pasajeroRepository.save(pasajero);
		        break;
		      }
		    }
	}
}
