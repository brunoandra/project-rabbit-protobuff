package br.com.metsys.rabbitprotobuff.pessoa;

import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.model.CreatePersonRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("person")
public interface CreatePersonApi {
    @PostMapping
    ResponseEntity<Void> execute(@RequestBody CreatePersonRequest createPersonRequest, @RequestHeader Map<String, String> headers) throws UseCaseException;
}
