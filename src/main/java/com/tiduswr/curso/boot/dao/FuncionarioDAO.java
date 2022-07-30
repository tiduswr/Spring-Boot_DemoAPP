package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Funcionario;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioDAO {
    public void save(Funcionario d);
    public void update(Funcionario d);
    public void delete(Long id);
    public Funcionario findById(Long id);
    public List<Funcionario> findAll();
    public List<Funcionario> findByNome(String nome);
    public List<Funcionario> findByCargoID(Long id);
    public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);
    public List<Funcionario> findByDataEntrada(LocalDate entrada);
    public List<Funcionario> findByDataSaida(LocalDate saida);
}
