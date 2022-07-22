package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.dao.DepartamentoDAO;
import com.tiduswr.curso.boot.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConcreteDepartamentoService implements DepartamentoService{

    @Autowired
    private DepartamentoDAO dao;

    @Override
    @Transactional(readOnly = false)
    public void salvar(Departamento d) {
        dao.save(d);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Departamento d) {
        dao.update(d);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }
}
