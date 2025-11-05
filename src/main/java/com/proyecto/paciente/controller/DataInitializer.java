package com.proyecto.paciente.controller;


import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.paciente.entidades.Paciente;
import com.proyecto.paciente.repository.PacienteRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initPacientes(PacienteRepository pacienteRepository) {
        return args -> {
            if (pacienteRepository.count() == 0) {
                System.out.println("🦷 Creando pacientes iniciales...");

                Paciente p1 = new Paciente("Juan", "Perez", "Calle Falsa 123", "10000001", "1000000001", "paciente@clinicadental.com", LocalDate.now());

                pacienteRepository.save(p1);

                
                System.out.println("Pacientes creados exitosamente");
            }
        };
    }
}
