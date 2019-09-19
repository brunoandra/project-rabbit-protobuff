package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.repository;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
