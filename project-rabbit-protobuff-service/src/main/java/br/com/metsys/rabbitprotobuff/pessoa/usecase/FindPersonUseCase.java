package br.com.metsys.rabbitprotobuff.pessoa.usecase;

import br.com.metsys.rabbitprotobuff.pessoa.exception.FindPersonUseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.FindPersonGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindPersonUseCase {
    private FindPersonGateway findPersonGateway;

    @Autowired
    public FindPersonUseCase(@Qualifier("findPersonGatewayImp") FindPersonGateway findPersonGateway) {
        this.findPersonGateway = findPersonGateway;
    }

    public PersonDomain execute(Long id) throws UseCaseException {

        try {
            Optional<PersonDomain> personDomain = findPersonGateway.execute(id);
            if (!personDomain.isPresent())
            {
                throw new FindPersonUseCaseException("Pessoa não encontrada");
            }
            return personDomain.get();

        }catch (GatewayException ex)
        {
            throw new FindPersonUseCaseException("Problema ao buscar a pessoa", ex);
        }
    }
}
