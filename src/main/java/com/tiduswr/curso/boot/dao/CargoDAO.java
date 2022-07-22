package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Cargo;

import java.util.List;

public interface CargoDAO {
    public void save(Cargo d);
    public void update(Cargo d);
    public void delete(Long id);
    public Cargo findById(Long id);
    public List<Cargo> findAll();
}
