package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.dao.FuncionarioDAO;
import com.tiduswr.curso.boot.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConcreteFuncionarioService implements FuncionarioService{

    @Autowired
    private FuncionarioDAO dao;

    @Override
    @Transactional(readOnly = false)
    public void salvar(Funcionario f) {
        dao.save(f);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Funcionario f) {
        dao.update(f);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}
