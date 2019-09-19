package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.translate;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model.PersonEntity;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.modelmapper.ModelMapper;

public class PersonDomainToPersonEntityTranslate {
    public static PersonEntity translator(PersonDomain personDomain) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personDomain, PersonEntity.class);
    }
}
