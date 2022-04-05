package br.com.barbearia.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbearia.gerenciador.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
