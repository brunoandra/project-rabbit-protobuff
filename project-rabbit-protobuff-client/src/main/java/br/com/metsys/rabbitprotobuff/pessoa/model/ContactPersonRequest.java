package br.com.metsys.rabbitprotobuff.pessoa.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ContactPersonRequest implements Serializable {

    private static final long serialVersionUID = -1882343528221488567L;

    private String ddd;
    private String numero;
    private boolean principal;
}
