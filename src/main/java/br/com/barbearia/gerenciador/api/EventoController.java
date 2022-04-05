package br.com.barbearia.gerenciador.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import br.com.barbearia.gerenciador.repository.ServicoRepository;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	
	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public List<EventoDto> eventos(@RequestParam(required = false) Long id) {
		
		if(id != null) {
			Optional<Evento> evento = eventoRepository.findById(id);
			
			if(evento.isPresent()) {
				return EventoDto.toDto(Arrays.asList(evento.get()));
			}
		}
		return EventoDto.toDto(eventoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public List<EventoDto> detalhaEvento(@PathVariable(required = false) Long id) {
		System.out.println(id);
		if(id != null) {
			Optional<Evento> evento = eventoRepository.findById(id);
			
			if(evento.isPresent()) {
				return EventoDto.toDto(Arrays.asList(evento.get()));
			}
		}
		return EventoDto.toDto(eventoRepository.findAll());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EventoDto> adicionaEvento(@RequestBody @Valid EventoForm form,
			UriComponentsBuilder uriBuilder){	
		Evento evento = form.converter(clienteRepository, servicoRepository);
		eventoRepository.save(evento);
		
		URI uri = uriBuilder.path("/api/eventos/{id}").buildAndExpand(evento.getId()).toUri();
		return ResponseEntity.created(uri).body(new EventoDto(evento));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EventoDto> editaEvento(@PathVariable Long id,
			@RequestBody @Valid EventoForm form){
		Optional<Evento> optional = eventoRepository.findById(id);
		if(optional.isPresent()) {
			Evento evento = form.atualizar(id, eventoRepository, clienteRepository, servicoRepository);
			return ResponseEntity.ok(new EventoDto(evento));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> removeEvento(@PathVariable Long id){
		Optional<Evento> optional = eventoRepository.findById(id);
		if(optional.isPresent()) {
			eventoRepository.delete(optional.get());
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	

	
	
}
