package ar.edu.unju.fi.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.enums.Nacionalidad;
import lombok.Data;

@Data
@Component
public class PasajeroDTO {

	private String dni;
	private String apellido;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String ciudad;
	private Nacionalidad nacionalidad;
	private boolean estado;
}
