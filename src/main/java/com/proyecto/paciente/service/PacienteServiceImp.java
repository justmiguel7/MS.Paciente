package com.proyecto.paciente.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  // <-- IMPORTANTE

import com.proyecto.paciente.entidades.Paciente;
import com.proyecto.paciente.repository.PacienteRepository;
import com.proyecto.paciente.dto.PacienteDTO;

@Service   // <-- ESTA ANOTACIÓN ES LA CLAVE
public class PacienteServiceImp implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente agregarPaciente(PacienteDTO pacienteDTO) throws Exception {
        String codigo = UUID.randomUUID().toString();
        return pacienteRepository.save(pacienteDTO.toEntity(codigo));
    }

    @Override
    public Paciente buscarPorNombre(String nombre) throws Exception {
        Optional<Paciente> optPaciente = pacienteRepository.findByNombre(nombre);
        return optPaciente.orElseThrow(() -> new Exception("Paciente no encontrado con nombre: " + nombre));
    }

    @Override  
    public Paciente buscarPorNombreYApellido(String nombre, String apellido) throws Exception {
        Optional<Paciente> optPaciente = pacienteRepository.findByNombreAndApellido(nombre, apellido);
        return optPaciente.orElseThrow(() -> new Exception("Paciente no encontrado con nombre y apellido: " + nombre + " " + apellido));
    }

    @Override
    public List<Paciente> listado() throws Exception {
        return pacienteRepository.findAll();
    }

    @Override
    public void eliminarPaciente(int dni) throws Exception {
        Optional<Paciente> optPaciente = pacienteRepository.findById(dni);
        Paciente paciente = optPaciente.orElseThrow(() -> new Exception("Paciente no encontrado con DNI: " + dni));
        pacienteRepository.delete(paciente);
    }
    
    @Override
    public Paciente buscarPorId(int id) throws Exception {
        Optional<Paciente> optPaciente = pacienteRepository.findByIdpaciente(id);
        return optPaciente.orElseThrow(() -> new Exception("Paciente no encontrado con id: " + id));
    }
}
