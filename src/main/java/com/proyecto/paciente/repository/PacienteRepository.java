package com.proyecto.paciente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.paciente.entidades.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

	public Optional<Paciente> findByNombre (String nombre) throws Exception; 
	
	public Optional<Paciente> findByNombreAndApellido (String nombre, String apellido) throws Exception; 

	public Optional<Paciente> findByIdpaciente (int pacienteid) throws Exception; 

}
