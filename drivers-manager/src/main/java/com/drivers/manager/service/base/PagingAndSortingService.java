//package com.drivers.manager.service.base;
//
//import java.io.Serializable;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import com.drivers.manager.web.resource.base.Pager;
//import com.drivers.repository.base.JpaSpecificationPagingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.transaction.annotation.Transactional;
//
//
///**
// * Title:
// * Description:
// * Copyright: Copyright (c) 2012
// * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
// *
// * @author xiejinjun
// * @version 1.0 2016/8/9
// */
//@Transactional
//public abstract class PagingAndSortingService<T, ID extends Serializable,Repository extends JpaSpecificationPagingRepository<T,ID>>{
//
//    protected Repository repository;
//
//    @Autowired
//    public EntityManager entityManager;
//
//    public Repository getRepository() {
//        return repository;
//    }
//    //由子类注入
//    public abstract void setRepository(Repository repository) ;
//
//    public <S extends T> S save(S entity) {
//        return repository.save(entity);
//    }
//    /**
//     * 修改对象里面有值的字段
//     * @Title: update
//     * @Description: TODO
//     * @param entity
//     * @return
//     * @throws Exception
//     * @return: S
//     */
//    public <S extends T> S update(S entity)throws Exception{
//        @SuppressWarnings("unchecked")
//        Class<S> clazz=(Class<S>) entity.getClass();
//        Field[] fields=clazz.getDeclaredFields();
//        String className=clazz.getSimpleName();
//        StringBuilder builder=new StringBuilder("update "+className+" set ");
//        int index=0;
//        List<Object> objs=new ArrayList<Object>();
//        for (Field field : fields) {
//            Column column=field.getAnnotation(Column.class);
//            String filedName=field.getName();
//            if(column!=null){
//                String methodfiledName = filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
//                Method method=clazz.getMethod("get"+methodfiledName);
//                Object obj=method.invoke(entity);
//                if(obj!=null){
//                    if(index==0){
//                        builder.append(" "+filedName+"=?"+index);
//                    }else{
//                        builder.append(","+filedName+"=?"+index);
//                    }
//                    index++;
//                    objs.add(obj);
//                }
//            }
//        }
//        Method method=clazz.getMethod("getId");
//        Object obj=method.invoke(entity);
//        if(obj==null){
//            throw new RuntimeException("主键为空不能修改!");
//        }
//        objs.add(obj);
//        builder.append(" where id=?"+index);
//        if(objs.size()>0){
//            Query query=entityManager.createQuery(builder.toString());
//            for (int i=0;i<objs.size();i++) {
//                query.setParameter(i, objs.get(i));
//            }
//            query.executeUpdate();
//        }
//        return entity;
//    }
//    public <S extends T> Iterable<S> save(Iterable<S> entities) {
//        return repository.save(entities);
//    }
//
//
//    public T findOne(ID id) {
//        return repository.findOne(id);
//    }
//
//
//    public boolean exists(ID id) {
//        return repository.exists(id);
//    }
//
//
//    public Iterable<T> findAll() {
//        return repository.findAll();
//    }
//
//
//    public Iterable<T> findAll(Iterable<ID> ids) {
//        return repository.findAll(ids);
//    }
//
//
//    public long count() {
//        return repository.count();
//    }
//
//
//    public void delete(ID id) {
//        repository.delete(id);
//    }
//
//
//    public void delete(T entity) {
//        repository.delete(entity);
//    }
//
//
//    public void delete(Iterable<? extends T> entities) {
//        repository.delete(entities);
//    }
//
//
//    public void deleteAll() {
//        repository.deleteAll();
//    }
//
//
//    public Iterable<T> findAll(Sort sort) {
//        return repository.findAll(sort);
//    }
//
//    public List<T> findListAll(){
//        return repository.findAll(new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
//                                         CriteriaBuilder cb) {
//                return null;
//            }
//        });
//    }
//    public void batchDelete(List<T> entities){
//        for (T e : entities) {
//            repository.delete(e);
//        }
//    }
//    public Iterator<T> batchDeleteIds(Collection<ID> ids){
//        Iterable<T> iterables=repository.findAll(ids);
//        repository.delete(iterables);
//        return iterables.iterator();
//    }
//    public void batchDelete(Iterator<T> entities){
//        while(entities.hasNext()){
//            T e=entities.next();
//            repository.delete(e);
//        }
//    }
//
//    public Pager<T> findPage(Pager<T> pager,Specification<T> specification){
//        Integer p=pager.getPage();
//        if(p.equals(0)){
//            p=1;
//        }
//        PageRequest request = new PageRequest(p-1,pager.getPageSize(), new Sort(Direction.DESC, "id"));
//        Page<T> page=repository.findAll(specification, request);
//        pager=setPager(pager, page);
//        return pager;
//    }
//    public Pager<T> findPage(Pager<T> pager,Specification<T> specification,Sort sort){
//        Integer p=pager.getPage();
//        if(p.equals(0)){
//            p=1;
//        }
//        PageRequest request = new PageRequest(p - 1,pager.getPageSize(),sort);
//        Page<T> page=repository.findAll(specification, request);
//        pager=setPager(pager, page);
//        return pager;
//    }
//    public Pager<T> findPage(Pager<T> pager,Sort sort){
//        Integer p=pager.getPage();
//        if(p.equals(0)){
//            p=1;
//        }
//        PageRequest request = new PageRequest(p - 1,pager.getPageSize(),sort);
//        Page<T> page=repository.findAll(new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
//                                         CriteriaBuilder cb) {
//                return null;
//            }
//        }, request);
//        pager=setPager(pager, page);
//        return pager;
//    }
//    private Pager<T> setPager(Pager<T> pager, Page<T> page) {
//        pager.setTotalPage(new Long(page.getTotalPages()));
//        pager.setRows(page.getContent());
//        pager.setTotal(page.getTotalElements());
//        return pager;
//    }
//    public Pager<T> findPage(Pager<T> pager){
//        Integer p=pager.getPage();
//        if(p.equals(0)){
//            p=1;
//        }
//        PageRequest request = new PageRequest(p - 1,pager.getPageSize());
//        Page<T> page=repository.findAll(new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
//                                         CriteriaBuilder cb) {
//                return null;
//            }
//        }, request);
//        pager=setPager(pager, page);
//        return pager;
//    }
//
//    public Page<T> findAll(Pageable pageable) {
//        return repository.findAll(pageable);
//    }
//}
