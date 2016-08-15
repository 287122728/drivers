package com.drivers.manager.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
public abstract class  CrudService<T, ID extends Serializable,Repository extends CrudRepository<T,ID>>{

    protected  Repository repository;

    @Autowired
    public EntityManager entityManager;

    public Repository getRepository() {
        return repository;
    }
    //由子类注入
    public abstract void setRepository(Repository repository) ;

    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }


    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        return repository.save(entities);
    }


    public T findOne(ID id) {
        return repository.findOne(id);
    }


    public boolean exists(ID id) {
        return repository.exists(id);
    }


    public Iterable<T> findAll() {
        return repository.findAll();
    }


    public Iterable<T> findAll(Iterable<ID> ids) {
        return repository.findAll(ids);
    }


    public long count() {
        return repository.count();
    }


    public void delete(ID id) {
        repository.delete(id);
    }


    public void delete(T entity) {
        repository.delete(entity);
    }


    public void delete(Iterable<? extends T> entities) {
        repository.delete(entities);
    }


    public void deleteAll() {
        repository.deleteAll();
    }
}
