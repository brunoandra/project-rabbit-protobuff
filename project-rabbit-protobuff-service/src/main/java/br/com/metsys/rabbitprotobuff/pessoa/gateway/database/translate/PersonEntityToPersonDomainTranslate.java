package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.translate;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model.PersonEntity;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.modelmapper.ModelMapper;

public class PersonEntityToPersonDomainTranslate {
    public static PersonDomain translator(PersonEntity personEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personEntity, PersonDomain.class);
    }
}
