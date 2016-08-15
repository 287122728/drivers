package com.drivers.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.drivers.jdbc.SimpleJdbcSupport;


public class CommonDaoImpl extends SimpleJdbcSupport{

    @PersistenceContext
	protected EntityManager entityManager;
    

}
