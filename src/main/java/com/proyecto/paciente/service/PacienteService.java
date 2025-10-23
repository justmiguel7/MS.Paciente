package com.proyecto.paciente.service;

import java.util.List;

import com.proyecto.paciente.entidades.Paciente;


import com.proyecto.paciente.dto.PacienteDTO;

public interface PacienteService {
	public Paciente agregarPaciente(PacienteDTO pacienteDTO ) throws Exception;

	public Paciente buscarPorNombre (String nombre) throws Exception;

	public Paciente buscarPorNombreYApellido (String nombre, String apellido) throws Exception;

	public List<Paciente> listado () throws Exception;

	public void eliminarPaciente (int dni) throws Exception;
	
	public Paciente buscarPorId (int id) throws Exception;

	
	

}
