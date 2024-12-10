package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Long> {

		List<Reserva> findReservaByEstado(Boolean estado);
		
	    List<Reserva> findByHabitacionCodigoAndFecha(long habitacionCodigo, LocalDate fecha);

}