package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Pasajero;

public interface IPasajeroService {

	public void guardarPasajero(Pasajero pasajero);
	public List<Pasajero> listarPasajeros();
	public void eliminarPasajero(String dni);
}
