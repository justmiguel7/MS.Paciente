package com.proyecto.paciente.service;

import java.util.List;

import com.proyecto.paciente.entidades.Paciente;
import com.proyecto.paciente.dto.PacienteDTO;

public interface PacienteService {
    Paciente agregarPaciente(PacienteDTO pacienteDTO) throws Exception;

    Paciente buscarPorNombre(String nombre) throws Exception;

    Paciente buscarPorNombreYApellido(String nombre, String apellido) throws Exception;

    List<Paciente> listado() throws Exception;

    void eliminarPaciente(int dni) throws Exception;

    Paciente buscarPorId(int id) throws Exception;

    Paciente buscarPorDni(String dni) throws Exception; // 🔹 NUEVO
}
