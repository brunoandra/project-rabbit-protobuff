package br.com.metsys.rabbitprotobuff.pessoa.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDomain implements Serializable {

    private static final long serialVersionUID = -1510086314768726870L;

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private List<PersonContactDomain> contatos;

}
