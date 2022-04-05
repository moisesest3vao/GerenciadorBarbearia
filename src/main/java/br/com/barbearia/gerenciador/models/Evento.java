package br.com.barbearia.gerenciador.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.barbearia.gerenciador.dto.EventoDto;

@Entity
public class Evento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JsonIgnore
	private Cliente cliente;
	@OneToOne
	private Servico servico;
	private Date data;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Optional<Servico> servico) {
		if(servico.isPresent()) {
			this.servico = servico.get();
		} else {
			
		}
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Optional<Cliente> cliente) {
		if(cliente.isPresent()) {
			this.cliente = cliente.get();
		} else {
			
		}
	}
	public Servico getServiço() {
		return servico;
	}
	public void setServiço(Servico serviço) {
		this.servico = serviço;
	}
	public Date getData() {
		return data;
	}
	
	public void setData(String data){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm");    
		try {
			Date parse = fmt.parse(data);
			Calendar cal = new GregorianCalendar();		
			cal.setTime(parse);
			cal.add(Calendar.HOUR_OF_DAY, -3);

			System.out.println(cal.getTime());
			
			this.data = cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
	
}
