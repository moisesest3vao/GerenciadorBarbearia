package br.com.barbearia.gerenciador.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.barbearia.gerenciador.models.Cliente;
import br.com.barbearia.gerenciador.models.Evento;
import br.com.barbearia.gerenciador.models.Servico;

public class EventoDto {

	private Long id;
	private String nomeCliente;
	private Servico servico;
	private Date data;	
	
	public EventoDto() {
		
	}
	
	public EventoDto(Evento evento) {
		this.setNomeCliente(evento.getCliente().getNome());
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

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	
	public static List<EventoDto> toDto(List<Evento> eventos) {
		List<EventoDto> dto = new ArrayList<>();
		for(Evento e : eventos) {
			EventoDto eventoDto = new EventoDto();
			eventoDto.setId(e.getId());
			eventoDto.setNomeCliente(e.getCliente().getNome());
			eventoDto.setServico(e.getServico()); 
			eventoDto.setData(e.getData());
			
			dto.add(eventoDto);		
		}
		
		return dto;
	}
	
	public static EventoDto toDto(Evento evento) {
		EventoDto eventoDto = new EventoDto();

		eventoDto.setId(evento.getId());
		eventoDto.setNomeCliente(evento.getCliente().getNome());
		eventoDto.setServico(evento.getServico()); 
		eventoDto.setData(evento.getData());
			
		return eventoDto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	
	
}
