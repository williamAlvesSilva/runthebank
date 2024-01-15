package br.com.runthebank.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.PessoaJuridicaDao;

@Service
public interface ClientePessoaJuridicaRepository extends JpaRepository<PessoaJuridicaDao, Long>{
	List<PessoaJuridicaDao> findByCnpj(String cnpj);
}
