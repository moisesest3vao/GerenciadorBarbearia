package br.com.barbearia.gerenciador.form;

import javax.validation.constraints.NotNull;
import br.com.barbearia.gerenciador.models.Evento;
import br.com.barbearia.gerenciador.repository.ClienteRepository;
import br.com.barbearia.gerenciador.repository.EventoRepository;
import br.com.barbearia.gerenciador.repository.ServicoRepository;

public class EventoForm {
	
	@NotNull
	private Long idCliente;
	@NotNull
	private Long idServico;
	@NotNull
	private String data;	
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public Evento converter(ClienteRepository clienteRepository, ServicoRepository servicoRepository) {
		
		Evento evento = new Evento();
		evento.setCliente(clienteRepository.findById(idCliente));
		evento.setData(data);
		evento.setServico(servicoRepository.findById(idServico));
		
		return evento;
	}

	public Evento atualizar(Long id, EventoRepository eventoRepository,
			ClienteRepository clienteRepository,ServicoRepository servicoRepository ) {
		Evento evento = eventoRepository.findById(id).get();
		System.out.println();
		evento.setCliente(clienteRepository.findById(this.idCliente));
		evento.setData(this.data);
		evento.setServico(servicoRepository.findById(this.idServico));
		
		return evento;
	}

}
