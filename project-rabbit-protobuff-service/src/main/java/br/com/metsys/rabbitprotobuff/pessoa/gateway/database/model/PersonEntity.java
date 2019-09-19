package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "person")
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 5786802975804066626L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String sobrenome;

    private String email;
    @ElementCollection
    private List<PersonContactEntity> contatos;
}
