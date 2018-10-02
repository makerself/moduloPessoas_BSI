package br.edu.up.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import br.edu.up.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	List<Pessoa> findByPrimeiroNome(String nome);
}
