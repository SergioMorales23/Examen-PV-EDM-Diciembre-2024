package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

import ar.edu.unju.fi.DTO.HabitacionDTO;
import ar.edu.unju.fi.model.Habitacion;

public interface HabitacionMapDTO {
	@Mapping(source="codigo",target="codigo") 
	@Mapping(source="tipo",target="tipo") // Source = nombre del atributo --- target = nombre del atributo en DTO
	@Mapping(source="servicio",target="servicio") 
	@Mapping(source="descripcion",target="descripcion") 
	@Mapping(source="estado",target="estado") 
	
	HabitacionDTO convertirHabitacionAHabitacionDTO(Habitacion a);
	
	@InheritInverseConfiguration //Revierte la confifuración anterior
	Habitacion convertirHabitacionDTOAHabitacion(HabitacionDTO ddto);	

	List<HabitacionDTO> convertirListHabitacionsAListHabitacionsDTO(List<Habitacion> listaHabitacion);
	
	List<Habitacion> convertirListHabitacionsDTOAListHabitacions(List<HabitacionDTO> listaHabitacionsDTO);

}
