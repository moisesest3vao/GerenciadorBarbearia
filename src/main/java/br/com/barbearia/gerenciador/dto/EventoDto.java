package br.com.barbearia.gerenciador.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.barbearia.gerenciador.models.Cliente;
import br.com.barbearia.gerenciador.models.Evento;
import br.com.barbearia.gerenciador.models.Servico;

public class EventoDto {

	private Long id;
	private Cliente cliente;
	private Servico servico;
	private LocalDate data;	
	
	public EventoDto() {
		
	}
	
	public EventoDto(Evento evento) {
		this.cliente = evento.getCliente();
		this.id = evento.getId();
		this.servico = evento.getServico();
		this.data = evento.getData();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	
	public static List<EventoDto> toDto(List<Evento> eventos) {
		List<EventoDto> dto = new ArrayList<>();
		for(Evento e : eventos) {
			EventoDto eventoDto = new EventoDto();
			eventoDto.setId(e.getId());
			eventoDto.setCliente(e.getCliente());
			eventoDto.setServico(e.getServico()); 
			eventoDto.setData(e.getData());
			
			dto.add(eventoDto);		
		}
		
		return dto;
	}

	
	
}
