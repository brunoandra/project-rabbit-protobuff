package br.com.metsys.rabbitprotobuff.pessoa.gateway.database;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.FindPersonGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.FindGatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model.PersonEntity;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.repository.PersonRepository;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.translate.PersonEntityToPersonDomainTranslate;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service("findPersonGatewayImp")
public class FindPersonGatewayImp implements FindPersonGateway {
    private PersonRepository personRepository;

    @Autowired
    public FindPersonGatewayImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<PersonDomain> execute(long id) throws GatewayException {
        try{
            PersonEntity personEntity = personRepository.getOne(id);

            PersonDomain personDomainReturn = PersonEntityToPersonDomainTranslate.translator(personEntity);

            return Optional.ofNullable(personDomainReturn);

        }catch (Exception ex)
        {
            throw new FindGatewayException("Problema ao buscar a pessoa", ex);
        }
    }
}
