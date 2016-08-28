package com.drivers.manager.service.impl;

import com.drivers.entity.Driver;
import com.drivers.manager.service.DriverService;
import com.drivers.manager.web.request.DriverReq;
import com.drivers.repository.DriverRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhuji on 2016/8/28.
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<Driver> findAllBySearch(DriverReq request, Pageable pageable) {
        Page<Driver> drivers = repository.findAll(getSpecification(request),pageable);
        if (drivers == null){
            drivers = new PageImpl<>(null,pageable,0);
        }
        return drivers;
    }

    private Specification<Driver> getSpecification(final DriverReq req){
        return new Specification<Driver>() {
            @Override
            public Predicate toPredicate(Root<Driver> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<>();
                String name = req.getName();
                if (StringUtils.isNotBlank(name)){
                    Path<String> nameExp = root.get("name");
                    list.add(criteriaBuilder.like(nameExp,"%"+name+"%"));
                }

                String mobile = req.getPhone();
                if (StringUtils.isNotBlank(mobile)){
                    Path<String> mobileExp = root.get("phone1");
                    list.add(criteriaBuilder.like(mobileExp,"%"+mobile+"%"));
                }

                String weixinNum = req.getModel();
                if (StringUtils.isNotBlank(weixinNum)){
                    Path<String> weixinNumExp = root.get("model");
                    list.add(criteriaBuilder.like(weixinNumExp,"%"+weixinNum+"%"));
                }

                Path<Integer> dataStatusExp = root.get("dataStatus");
                list.add(criteriaBuilder.equal(dataStatusExp,1));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}
