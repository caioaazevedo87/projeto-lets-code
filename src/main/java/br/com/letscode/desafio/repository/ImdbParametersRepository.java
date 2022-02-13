package br.com.letscode.desafio.repository;

import br.com.letscode.desafio.domain.model.ImdbParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImdbParametersRepository extends CrudRepository<ImdbParameter, Long> {

    Optional<ImdbParameter> findByKey(String key);

}