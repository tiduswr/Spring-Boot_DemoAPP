package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class ConcreteDepartamentoDAO extends AbstractDao<Departamento, Long> implements DepartamentoDAO {}
