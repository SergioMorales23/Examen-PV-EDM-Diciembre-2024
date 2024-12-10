package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.enums.Nacionalidad;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Data
@Component
@Entity
@Table(name="pasajeros")
public class Pasajero {
	
	@Id
	@NotBlank(message = "El DNI no puede estar vacío")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 dígitos")
    private String dni;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "La ciudad no puede estar vacía")
    private String ciudad;

    @NotNull(message = "La nacionalidad no puede ser nula")
    @Enumerated(EnumType.STRING)
    private Nacionalidad nacionalidad;

    private boolean estado;
}
