package br.com.barbearia.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbearia.gerenciador.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
