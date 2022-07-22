package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class ConcreteCargoDAO extends AbstractDao<Cargo, Long> implements CargoDAO{
}
