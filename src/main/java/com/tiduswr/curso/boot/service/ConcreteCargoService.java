package com.tiduswr.curso.boot.service;

import com.tiduswr.curso.boot.dao.CargoDAO;
import com.tiduswr.curso.boot.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ConcreteCargoService implements CargoService{

    @Autowired
    private CargoDAO dao;

    @Override
    public void salvar(Cargo c) {
        dao.save(c);
    }

    @Override
    public void editar(Cargo c) {
        dao.update(c);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionario(Long id) {
        Cargo c = dao.findById(id);
        if(c != null) return !c.getFuncionarios().isEmpty();
        return false;
    }
}
