package br.com.metsys.rabbitprotobuff.pessoa.usecase;

import br.com.metsys.rabbitprotobuff.pessoa.exception.CreatePersonUseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.FindPersonGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.PersonMessage;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.SavePersonGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CreatePersonUseCase {
    private SavePersonGateway savePersonGateway;
    private FindPersonGateway findPersonGateway;

    @Autowired
    public CreatePersonUseCase(SavePersonGateway savePersonGateway,@Qualifier("findPersonGatewayFeignImp") FindPersonGateway findPersonGateway) {
        this.savePersonGateway = savePersonGateway;

        this.findPersonGateway = findPersonGateway;
    }

    public PersonDomain execute(PersonDomain personDomain) throws UseCaseException {
        PersonDomain personDomainReturn;
        try {
            System.out.print(personDomain);
            PersonMessage.personMessage personMessage =
                    PersonMessage.personMessage.newBuilder()
                            .setNome(personDomain.getNome())
                            .setEmail(personDomain.getEmail()).build();
            System.out.print(personMessage.toByteString());
            System.out.print("\n");
            personDomainReturn = savePersonGateway.execute(personDomain);
            Optional<PersonDomain> personDomain1 = findPersonGateway.execute(personDomainReturn.getId());


            return personDomainReturn;
        } catch (GatewayException ex) {
            throw new CreatePersonUseCaseException("Problema na criação da pessoa", ex);
        }

    }
}

