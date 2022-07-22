package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {
    public void salvar(Funcionario c);
    public void editar(Funcionario c);
    public void excluir(Long id);
    public Funcionario buscarPorId(Long id);
    public List<Funcionario> buscarTodos();
}
