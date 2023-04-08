package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //abstrair getters, setters, equals e hashcode
@NoArgsConstructor //criar constructor vazio
@AllArgsConstructor //criar constructor com todos os atributos
@Entity //persistir no bd
@Table(name = "tb_alunos") //definindo tabela
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //hibernate terá inicialização lenta
public class Aluno {

  @Id //chave primaria
  @GeneratedValue(strategy = GenerationType.IDENTITY) //como sera gerada a chave primaria
  private Long id;

  private String nome;

  @Column(unique = true) //unico para cada alunoId
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  //um(1) aluno para varias(n) avaliações físicas
  //LAZY: carregar todas as info, menos a lista de avaliações físicas -- melhorar performance
  @JsonIgnore //ignorar exceções json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
