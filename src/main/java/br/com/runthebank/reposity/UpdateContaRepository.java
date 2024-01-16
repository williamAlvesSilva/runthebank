package br.com.runthebank.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.ContaPessoaDao;

@Service
public interface UpdateContaRepository extends JpaRepository<ContaPessoaDao, Long>{
	List<ContaPessoaDao> findByAgenciaKeyID(String agenciaKeyID);
}
