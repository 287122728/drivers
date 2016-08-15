package com.drivers.repository.base;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
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
public class CustomRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, Serializable>
        implements CustomRepository<T, Serializable>{

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }
    public CustomRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        // Keep the EntityManager around to used from the newly introduced methods.
        this.entityManager = entityManager;
    }
//    @Override
//    public Integer invalid(T obj) {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaUpdate<T> update = builder.createCriteriaUpdate((Class<T>) obj.getClass());
//        Root<T> root = update.from((Class<T>) obj.getClass());
////        update.set()
//        update.where(builder.equal(root.get("data_status")))
//        Query query = entityManager.createQuery(CriteriaUpdate CriteriaUpdate)
////        entityManager.c
//        return null;
//    }
}
