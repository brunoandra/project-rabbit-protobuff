package br.com.metsys.rabbitprotobuff.pessoa.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonContactDomain implements Serializable {

    private static final long serialVersionUID = 7288244280436242799L;

    private String ddd;
    private String numero;
    private boolean principal;

}
