package br.com.runthebank.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.model.PessoaFisica;

@Service
public interface ClientePessoaFisicaRepository extends JpaRepository<PessoaFisicaDao, Long>{
	List<PessoaFisicaDao> findByCpf(String cpf);
}
