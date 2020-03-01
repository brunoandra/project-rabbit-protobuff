package br.com.metsys.rabbitprotobuff.pessoa.controller;

import br.com.metsys.rabbitprotobuff.pessoa.CreatePersonApi;
import br.com.metsys.rabbitprotobuff.pessoa.controller.translate.CreatePersonRequestToPersonDomainTranslate;
import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.PersonCreatedJsonPublisherGatewayImp;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.PersonCreatedProtobuffPublisherGatewayImp;
import br.com.metsys.rabbitprotobuff.pessoa.model.CreatePersonRequest;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CreatePersonController implements CreatePersonApi {
    @Autowired
    private PersonCreatedJsonPublisherGatewayImp personCreatedJsonPublisherGateway;
    @Autowired
    private PersonCreatedProtobuffPublisherGatewayImp personCreatedProtobuffPublisherGateway;

    private Logger logger = LoggerFactory.getLogger(CreatePersonController.class);


    @SneakyThrows
    @Override
    public ResponseEntity<Void> execute(@RequestBody final CreatePersonRequest createPersonRequest, @RequestHeader Map<String, String> headers) throws UseCaseException {
        try{
            headers.forEach((key, value) -> {
                logger.info(String.format("Header '%s' = %s", key, value));
            });
            PersonDomain personDomain = CreatePersonRequestToPersonDomainTranslate.translator(createPersonRequest);

            personCreatedJsonPublisherGateway.publish(personDomain);
            personCreatedProtobuffPublisherGateway.publish(personDomain);

            ResponseEntity<Void> response = new ResponseEntity<>( HttpStatus.OK);
            return response;
        }catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw e;
        }

    }
}
