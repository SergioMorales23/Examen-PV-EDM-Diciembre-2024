package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Reserva;
import ar.edu.unju.fi.repository.ReservaRepository;
import ar.edu.unju.fi.service.IReservaService;

@Service
public class ReservaServiceImp implements IReservaService{

	@Autowired
	ReservaRepository reservaRepository;
	
	@Override
	public void guardarReserva(Reserva reserva) {
		reserva.setEstado(true);
		reservaRepository.save(reserva);
		
	}

	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		//return alumnoRepository.findAll();
		return reservaRepository.findReservaByEstado(true);
	}

	@Override
	public void eliminarReserva(long codigo) {
		// TODO Auto-generated method stub
		List<Reserva> todosLosReservas = reservaRepository.findAll();
		for (int i = 0; i < todosLosReservas.size(); i++) {
		      Reserva reserva = todosLosReservas.get(i);
		      if (reserva.getCodigo() == codigo) {
		        reserva.setEstado(false);
		        reservaRepository.save(reserva);
		        break;
		      }
		    }
	}

	
	
}
