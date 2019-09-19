package br.com.metsys.rabbitprotobuff.pessoa.listener;

import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.sink.PersonCreatedSink;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import br.com.metsys.rabbitprotobuff.pessoa.usecase.CreatePersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding({PersonCreatedSink.class})
public class ReceiveCreatePerson {

    private final CreatePersonUseCase createPersonUseCase;

    @Autowired
    public ReceiveCreatePerson(CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    @StreamListener(target = PersonCreatedSink.INPUT)
    public void execute(PersonDomain personDomain) throws UseCaseException {
        createPersonUseCase.execute(personDomain);
    }

}
