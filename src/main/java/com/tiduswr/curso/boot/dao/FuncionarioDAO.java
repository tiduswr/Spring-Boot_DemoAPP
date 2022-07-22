package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Funcionario;

import java.util.List;

public interface FuncionarioDAO {
    public void save(Funcionario d);
    public void update(Funcionario d);
    public void delete(Long id);
    public Funcionario findById(Long id);
    public List<Funcionario> findAll();
}
