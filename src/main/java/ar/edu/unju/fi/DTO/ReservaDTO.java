package ar.edu.unju.fi.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Habitacion;
import ar.edu.unju.fi.model.Pasajero;
import lombok.Data;


@Data
@Component
public class ReservaDTO {

	private String codigo;
	private LocalDate fecha;
	private Pasajero pasajero;
	private Habitacion habitacion;
	private boolean estado;
}
