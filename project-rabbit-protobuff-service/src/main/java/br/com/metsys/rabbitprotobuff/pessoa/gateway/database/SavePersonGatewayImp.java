package br.com.metsys.rabbitprotobuff.pessoa.gateway.database;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.SavePersonGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.SaveGatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model.PersonEntity;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.repository.PersonRepository;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.translate.PersonDomainToPersonEntityTranslate;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.translate.PersonEntityToPersonDomainTranslate;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePersonGatewayImp implements SavePersonGateway {
    private PersonRepository personRepository;

    @Autowired
    public SavePersonGatewayImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDomain execute(PersonDomain personDomain) throws GatewayException {

        try {
            PersonEntity personEntity = PersonDomainToPersonEntityTranslate.translator(personDomain);
            personEntity = personRepository.save(personEntity);

            PersonDomain personDomainReturn = PersonEntityToPersonDomainTranslate.translator(personEntity);

            return personDomainReturn;
        } catch (Exception ex) {
            throw new SaveGatewayException("Problema ao salvar Person", ex);
        }
    }
}
