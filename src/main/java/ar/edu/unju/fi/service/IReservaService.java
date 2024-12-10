package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Reserva;

public interface IReservaService {

	public void guardarReserva(Reserva reserva);
	public List<Reserva> listarReservas();
	public void eliminarReserva(long codigo);
}
