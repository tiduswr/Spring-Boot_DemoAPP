package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.domain.Funcionario;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioService {
    public void salvar(Funcionario c);
    public void editar(Funcionario c);
    public void excluir(Long id);
    public Funcionario buscarPorId(Long id);
    public List<Funcionario> buscarTodos();
    public List<Funcionario> buscarPorNome(String nome);
    public List<Funcionario> buscarPorCargo(Long id);
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
