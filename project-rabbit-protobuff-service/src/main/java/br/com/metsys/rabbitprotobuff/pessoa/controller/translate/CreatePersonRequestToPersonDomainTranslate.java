package br.com.metsys.rabbitprotobuff.pessoa.controller.translate;

import br.com.metsys.rabbitprotobuff.pessoa.model.CreatePersonRequest;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.modelmapper.ModelMapper;

public class CreatePersonRequestToPersonDomainTranslate {
    public static PersonDomain translator(CreatePersonRequest createPersonRequest) {
        ModelMapper modelMapper = new ModelMapper();
        PersonDomain personDomain = modelMapper.map(createPersonRequest, PersonDomain.class);

        personDomain = PersonDomain.builder()
                .nome(createPersonRequest.getNome())
                .sobrenome(createPersonRequest.getSobrenome())
                .email(createPersonRequest.getEmail())
                .build();
        return personDomain;
    }
}
