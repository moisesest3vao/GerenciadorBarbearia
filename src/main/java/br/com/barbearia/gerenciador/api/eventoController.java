package br.com.barbearia.gerenciador.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.barbearia.gerenciador.dto.EventoDto;
import br.com.barbearia.gerenciador.form.EventoForm;
import br.com.barbearia.gerenciador.models.Evento;
import br.com.barbearia.gerenciador.repository.ClienteRepository;
import br.com.barbearia.gerenciador.repository.EventoRepository;

@RestController
@RequestMapping("/api/eventos")
public class eventoController {
	
	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public List<EventoDto> getEvento(@RequestParam(required = false) Long id) {
		if(id != null) {
			Optional<Evento> evento = eventoRepository.findById(id);
			
			if(evento.isPresent()) {
				return EventoDto.toDto(Arrays.asList(evento.get()));
			}
		}
		return EventoDto.toDto(eventoRepository.findAll());
		
	}
}
