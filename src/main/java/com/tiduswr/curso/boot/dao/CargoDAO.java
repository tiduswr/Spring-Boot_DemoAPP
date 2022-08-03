package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Cargo;
import com.tiduswr.curso.boot.util.PaginacaoUTIL;

import java.util.List;

public interface CargoDAO {
    public void save(Cargo d);
    public void update(Cargo d);
    public void delete(Long id);
    public Cargo findById(Long id);
    public List<Cargo> findAll();
    public PaginacaoUTIL<Cargo> buscaPaginada(int tamanho, int pagina, String direcao, String col);
    public long count();
}
