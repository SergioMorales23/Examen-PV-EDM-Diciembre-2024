	package ar.edu.unju.fi.model;
	
	import org.springframework.stereotype.Component;
	
	import ar.edu.unju.fi.enums.Tipo;
	import jakarta.persistence.Entity;
	import jakarta.persistence.EnumType;
	import jakarta.persistence.Enumerated;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.NotNull;
	import lombok.Data;
	
	@Data
	@Component
	@Entity
	@Table(name="habitaciones")
	public class Habitacion {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long codigo;
	
	    @NotNull(message = "El tipo no puede ser nulo")
	    @Enumerated(EnumType.STRING)
	    private Tipo tipo;
	
	    @NotBlank(message = "El servicio no puede estar vacío")
	    private String servicio;
	
	    @NotBlank(message = "La descripción no puede estar vacía")
	    private String descripcion;
	
	    private boolean estado;
		
	}
