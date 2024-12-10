package ar.edu.unju.fi.map;

import java.util.List;

	import org.mapstruct.InheritInverseConfiguration;
	import org.mapstruct.Mapper;
	import org.mapstruct.Mapping;
	import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.PasajeroDTO;
import ar.edu.unju.fi.model.Pasajero;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface PasajeroMapDTO {

		@Mapping(source="dni",target="dni") 
		@Mapping(source="apellido",target="apellido") 
		@Mapping(source="nombre",target="nombre") // Source = nombre del atributo de alumno --- target = nombre del atributo en DTO
		@Mapping(source="fechaNacimiento",target="fechaNacimiento") 
		@Mapping(source="ciudad",target="ciudad") 
		@Mapping(source="nacionalidad",target="nacionalidad") 
		@Mapping(source="estado",target="estado") 
		PasajeroDTO convertirAlumnoAAlumnoDTO(Pasajero a);
		
		@InheritInverseConfiguration //Revierte la confifuración anterior
		Pasajero convertirAlumnoDTOAAlumno(PasajeroDTO ddto);	

		List<PasajeroDTO> convertirListaAlumnosAListaAlumnosDTO(List<Pasajero> listaPasajeros);
		
		List<Pasajero> convertirListaAlumnosDTOAListaAlumnos(List<PasajeroDTO> listaPasajerosDTO);

	}


