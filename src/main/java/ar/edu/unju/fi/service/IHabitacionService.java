package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Habitacion;

public interface IHabitacionService {

	public void guardarHabitacion(Habitacion habitacion);
	public List<Habitacion> listarHabitaciones();
	public void eliminarHabitacion (long codigo);
}
