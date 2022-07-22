package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.domain.Departamento;

import java.util.List;

public interface DepartamentoService {
    public void salvar(Departamento c);
    public void editar(Departamento c);
    public void excluir(Long id);
    public Departamento buscarPorId(Long id);
    public List<Departamento> buscarTodos();
}
