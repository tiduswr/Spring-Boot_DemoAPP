package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.domain.Cargo;

import java.util.List;

public interface CargoService {
    public void salvar(Cargo c);
    public void editar(Cargo c);
    public void excluir(Long id);
    public Cargo buscarPorId(Long id);
    public List<Cargo> buscarTodos();
}