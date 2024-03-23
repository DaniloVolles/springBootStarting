package br.com.springboot.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "user_id") // Caso os nomes da tabela batam com o os nomes desses atributos, não precisa especificar
    private Long id;

    private String name;
    private String username;


}
