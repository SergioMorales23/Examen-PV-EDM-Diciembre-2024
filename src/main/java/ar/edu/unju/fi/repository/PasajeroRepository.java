package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Pasajero;

@Repository
public interface PasajeroRepository extends JpaRepository <Pasajero,String> {

		List<Pasajero> findPasajeroByEstado(Boolean estado);
}

