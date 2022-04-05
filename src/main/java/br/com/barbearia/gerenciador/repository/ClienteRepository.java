package br.com.barbearia.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbearia.gerenciador.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
