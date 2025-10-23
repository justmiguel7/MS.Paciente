package com.proyecto.paciente.entidades;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpaciente;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "direccion")
	private String direccion;

	@Column(name = "dni")
	private String dni;
	
	@Column(name = "telefono")
	private String telefono;

	@Column(name = "email")
	private String email;
	
	@Column(name = "fechaRegistro")
	private LocalDate fecharegistro;
	


	
	
	public Paciente(String nombre, String apellido,String direccion , String dni, String telefono, String email, LocalDate fecharegistro) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion =  direccion;
		this.dni =  dni;
		this.telefono = telefono;
		this.email = email;
		this.fecharegistro =  fecharegistro;
	}
	
	public Paciente(){
		
	}



	
}
