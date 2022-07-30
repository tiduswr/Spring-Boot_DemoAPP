package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ConcreteFuncionarioDAO extends AbstractDao<Funcionario, Long> implements FuncionarioDAO{
    @Override
    public List<Funcionario> findByNome(String nome) {
        return createQuery("SELECT f FROM Funcionario f WHERE f.nome LIKE concat('%', ?1, '%')", nome);
    }

    @Override
    public List<Funcionario> findByCargoID(Long id) {
        return createQuery("SELECT f FROM Funcionario f WHERE f.cargo.id = ?1", id);
    }

    @Override
    public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
        String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
                .append("WHERE f.dataEntrada >= ?1 AND f.dataSaida <= ?2 ")
                .append("ORDER BY f.dataEntrada ASC")
                .toString();
        return createQuery(jpql, entrada, saida);
    }

    @Override
    public List<Funcionario> findByDataEntrada(LocalDate entrada) {
        String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
                .append("WHERE f.dataEntrada = ?1 ")
                .append("ORDER BY f.dataEntrada ASC")
                .toString();
        return createQuery(jpql, entrada);
    }

    @Override
    public List<Funcionario> findByDataSaida(LocalDate saida) {
        String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
                .append("WHERE f.dataSaida = ?1 ")
                .append("ORDER BY f.dataSaida ASC")
                .toString();
        return createQuery(jpql, saida);
    }
}
