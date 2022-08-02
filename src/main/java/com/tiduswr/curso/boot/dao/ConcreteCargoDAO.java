package com.tiduswr.curso.boot.dao;

import com.tiduswr.curso.boot.domain.Cargo;
import com.tiduswr.curso.boot.util.PaginacaoUTIL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConcreteCargoDAO extends AbstractDao<Cargo, Long> implements CargoDAO{

    public PaginacaoUTIL<Cargo> buscaPaginada(int tamanho, int pagina, String direcao){
        int inicio = (pagina - 1) * tamanho;
        long totalCargos = count();
        long totalPaginas = (totalCargos + (tamanho - 1)) / tamanho;


        List<Cargo> cargos = getEntityManager()
                .createQuery("SELECT c FROM Cargo c ORDER BY c.nome " + direcao, Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        return new PaginacaoUTIL<>(tamanho, pagina, totalPaginas, direcao, cargos);
    }

    public long count(){
        return getEntityManager().createQuery("SELECT count(*) FROM Cargo", Long.class).getSingleResult();
    }

}
