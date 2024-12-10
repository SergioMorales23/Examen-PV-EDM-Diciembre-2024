package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
@Entity
@Table(name="reservas")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Future(message = "La fecha de reserva debe ser en el futuro")
    private LocalDate fecha;

    @NotNull(message = "El pasajero no puede ser nulo")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasajero_dni")
    private Pasajero pasajero;

    @NotNull(message = "La habitación no puede ser nula")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_habitacion")
    private Habitacion habitacion;
    
    private boolean estado;
}
