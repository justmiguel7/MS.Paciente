package com.proyecto.paciente.dto;





import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.proyecto.paciente.entidades.Paciente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PacienteDTO {
	
	
	private int idpaciente;
	
	
		
	@NotEmpty
	@Size(min = 4, max = 30, message = "la longitud del nombre es entre 4 y 30 caracteres" )
	private String nombre;

	
	@NotEmpty
	@Size(min = 4, max = 40,  message = "la longitud del apellido es entre 4 y 30 caracteres")
	private String apellido;
	
	@NotEmpty
	@Size(min = 4, max = 20 , message = "la longitud de la direccion es entre 4 y 30 caracteres")
	private String direccion;
	
	@NotEmpty
	@Size(min = 8, max = 8 , message = "la longitud del dni tiene que ser de 8 digitos")
	private String dni;
	
	@NotEmpty
	@Size(min = 10, max = 12 , message = "la longitud del dni tiene que ser de 8 digitos")
	private String telefono;

	@NotEmpty
	@Size(min = 4, max = 20 , message = "la longitud de la direccion es entre 4 y 30 caracteres")
	private String email;
	
	
	private LocalDate fecharegistro;

	
	public Paciente toEntity( String codigo ){
		return new Paciente(this.nombre, this.apellido, this.direccion,this.dni ,this.telefono,this.email,this.fecharegistro);
	}

	
	
	public PacienteDTO(String nombre, String apellido,String direccion , String dni, String telefono, String email, LocalDate fecharegistro ) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion =  direccion;
		this.dni =  dni;
		this.telefono = telefono;
		this.email = email;
		this.fecharegistro =  fecharegistro;
	}
	
	public PacienteDTO() {
		
	}
	

    public static PacienteDTO fromEntity(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setIdpaciente(paciente.getIdpaciente());
        dto.setNombre(paciente.getNombre());
        dto.setApellido(paciente.getApellido());
        dto.setDni(paciente.getDni());
        dto.setTelefono(paciente.getTelefono());
        dto.setEmail(paciente.getEmail());
        return dto;
    }





}