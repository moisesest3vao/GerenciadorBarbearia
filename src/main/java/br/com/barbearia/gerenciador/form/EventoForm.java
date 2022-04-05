package br.com.barbearia.gerenciador.form;

import java.time.LocalDate;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.barbearia.gerenciador.models.Cliente;
import br.com.barbearia.gerenciador.models.Evento;
import br.com.barbearia.gerenciador.models.Servico;
import br.com.barbearia.gerenciador.repository.ClienteRepository;

public class EventoForm {
	
	@NotNull
	private Cliente cliente;
	@NotNull
	private Servico servico;
	@NotNull
	private LocalDate data;	
	
	public Evento converter(ClienteRepository clienteRepository) {
		Evento evento = new Evento();
		evento.setCliente(cliente);
		evento.setData(data);
		evento.setServico(servico);
		
		return evento;
	}

}
