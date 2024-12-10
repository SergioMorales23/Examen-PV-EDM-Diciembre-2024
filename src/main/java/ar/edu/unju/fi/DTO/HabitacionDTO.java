package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.enums.Tipo;
import lombok.Data;


@Data
@Component
public class HabitacionDTO {

	private String codigo;
	private Tipo tipo;
	private String servicio;
	private String descripcion;
	private boolean estado;
}
