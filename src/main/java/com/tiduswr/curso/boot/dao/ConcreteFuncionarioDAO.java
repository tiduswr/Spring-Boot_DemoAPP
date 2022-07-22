package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class ConcreteFuncionarioDAO extends AbstractDao<Funcionario, Long> implements FuncionarioDAO{
}
