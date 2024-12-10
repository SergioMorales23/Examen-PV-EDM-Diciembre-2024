package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository <Habitacion,String> {

		List<Habitacion> findHabitacionByEstado(Boolean estado);
}
