package it.si2001.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<PK extends Serializable, T>
{

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao()
    {
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                                                                                .getActualTypeArguments()[1];
    }

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager()
    {
        return this.entityManager;
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key)
    {
        return (T) entityManager.find(persistentClass, key);
    }

    public void persist(T entity)
    {
        entityManager.persist(entity);
    }

    public void update(T entity)
    {
        entityManager.merge(entity);
    }

    public void delete(T entity)
    {
        entityManager.remove(entity);
    }

}
