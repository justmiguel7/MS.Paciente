package com.proyecto.paciente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.paciente.entidades.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Optional<Paciente> findByNombre(String nombre);

    Optional<Paciente> findByNombreAndApellido(String nombre, String apellido);

    Optional<Paciente> findByIdpaciente(int pacienteid);

    Optional<Paciente> findByDni(String dni);
}
