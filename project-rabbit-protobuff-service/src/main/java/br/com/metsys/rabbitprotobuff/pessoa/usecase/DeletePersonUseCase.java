package br.com.metsys.rabbitprotobuff.pessoa.usecase;

import br.com.metsys.rabbitprotobuff.pessoa.exception.DeletePersonUseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.DeletePersonGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase {
    private DeletePersonGateway deletePersonGateway;

    @Autowired
    public DeletePersonUseCase(DeletePersonGateway deletePersonGateway) {
        this.deletePersonGateway = deletePersonGateway;
    }
    public void execute(Long id) throws UseCaseException{
        try{
            deletePersonGateway.execute(id);
        }catch (GatewayException ex)
        {
            throw new DeletePersonUseCaseException("Problema ao deletar a pessoa",ex);
        }
    }
}
