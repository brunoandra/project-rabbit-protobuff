package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "personcontact")
public class PersonContactEntity implements Serializable {

    private static final long serialVersionUID = 7288244280436242799L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ddd;
    private String numero;
    private boolean principal;

}
