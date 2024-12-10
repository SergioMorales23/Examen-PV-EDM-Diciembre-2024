package ar.edu.unju.fi.map;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.ReservaDTO;
import ar.edu.unju.fi.model.Reserva;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ReservaMapDTO {

		@Mapping(source="codigo",target="codigo") 
		@Mapping(source="fecha",target="fecha") // Source = nombre del atributo de alumno --- target = nombre del atributo en DTO
		@Mapping(source="pasajero",target="pasajero") 
		@Mapping(source="habitacion",target="habitacion") 
		@Mapping(source="estado",target="estado") 
		ReservaDTO convertirReservaAReservaDTO(Reserva a);
		
		@InheritInverseConfiguration //Revierte la confifuración anterior
		Reserva convertirReservaDTOAReserva(ReservaDTO ddto);	

		List<ReservaDTO> convertirListaReservasAListaReservasDTO(List<Reserva> listaReserva);
		
		List<Reserva> convertirListaReservasDTOAListaReservas(List<ReservaDTO> listaReservasDTO);

	}


