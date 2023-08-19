package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Cliente extends Pessoa {

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String atividade;

}
