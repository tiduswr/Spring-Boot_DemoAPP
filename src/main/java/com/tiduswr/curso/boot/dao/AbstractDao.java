package com.tiduswr.curso.boot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<T, PK extends Serializable> {

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>)
            ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    //O Spring vai se encarregar de injetar essa dependencia aqui
    //Por causa da Anotação @PersistenceContext
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return entityManager;
    }

    public void save(T e){
        entityManager.persist(e);
    }

    public void update(T e){
        entityManager.merge(e);
    }

    public void delete(PK id){
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public T findById(PK id){
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll(){
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params){
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for(int i = 0; i < params.length; i++){
            query.setParameter(i+1, params[i]);
        }
        return query.getResultList();
    }

}
