package br.com.metsys.rabbitprotobuff.pessoa.model;

import lombok.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest implements Serializable {

    private static final long serialVersionUID = -4259328315821535161L;
    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private List<ContactPersonRequest> contatos;
}
