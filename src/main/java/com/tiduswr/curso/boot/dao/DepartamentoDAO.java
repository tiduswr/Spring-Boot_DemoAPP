package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Departamento;

import java.util.List;

public interface DepartamentoDAO {
    public void save(Departamento d);
    public void update(Departamento d);
    public void delete(Long id);
    public Departamento findById(Long id);
    public List<Departamento> findAll();
}
