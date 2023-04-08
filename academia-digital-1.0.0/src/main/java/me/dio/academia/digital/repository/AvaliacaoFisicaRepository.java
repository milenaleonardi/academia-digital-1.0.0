package me.dio.academia.digital.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvalicaoFisica, Long> {

    List<AvaliacaoFisica> findAlunosPesoAltura (Double peso, Double altura);
}
