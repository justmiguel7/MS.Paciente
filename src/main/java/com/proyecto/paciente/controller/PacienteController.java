package com.proyecto.paciente.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.paciente.entidades.Paciente;
import com.proyecto.paciente.dto.PacienteDTO;

import com.proyecto.paciente.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "false")
@RequestMapping("/paciente")
public class PacienteController {

	
	
	@Autowired
	private PacienteService pacienteService;
		

  @RequestMapping(value="/agregar", method={RequestMethod.POST})
	public ResponseEntity<PacienteDTO> persistirPaciente (@Valid @RequestBody  PacienteDTO pacienteDTO ) throws Exception{
		
		pacienteService.agregarPaciente(pacienteDTO);

		return new ResponseEntity<PacienteDTO>(pacienteDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/buscarnombre/{nombre}", method={RequestMethod.GET})
	public ResponseEntity<Paciente> busarPorNombre ( @PathVariable("nombre") String nombre) throws Exception{
		Paciente paciente = pacienteService.buscarPorNombre(nombre);
		  return new ResponseEntity<>(paciente,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/buscarid/{id}", method={RequestMethod.GET})
	public ResponseEntity<Paciente> busarPorId ( @PathVariable("id") int id) throws Exception{
		Paciente paciente = pacienteService.buscarPorId(id);
		  return new ResponseEntity<>(paciente,HttpStatus.OK);
	}
	

	

	
	
	@RequestMapping(value="/buscarPorapellido/{nombre}/{apellido}", method={RequestMethod.GET})
	public ResponseEntity<Paciente> buscarPorApellido ( @PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido) throws Exception{
		Paciente paciente = pacienteService.buscarPorNombreYApellido(nombre, apellido);
		  return new ResponseEntity<>(paciente,HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/listado", method={RequestMethod.GET})
	public ResponseEntity<List<Paciente>> listado() throws Exception{
		  return new ResponseEntity<>(pacienteService.listado(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/eliminar/{id}", method={RequestMethod.GET})
	public ResponseEntity<Paciente> eliminarPaciente(@PathVariable("id") int dni) throws Exception{
			pacienteService.eliminarPaciente(dni);
		  return new ResponseEntity<>(HttpStatus.OK);
	}
	
    // 🔹 NUEVO endpoint para BFF
    @GetMapping("/buscarPorDni/{dni}")
    public ResponseEntity<PacienteDTO> buscarPorDni(@PathVariable String dni) throws Exception {
        Paciente paciente = pacienteService.buscarPorDni(dni);
        PacienteDTO dto = PacienteDTO.fromEntity(paciente); // Asegurate de tener este método en tu DTO
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
	
	
	
}

