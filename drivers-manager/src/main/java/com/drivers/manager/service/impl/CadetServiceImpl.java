package com.drivers.manager.service.impl;

import com.drivers.entity.Cadet;
import com.drivers.manager.service.CadetService;
import com.drivers.manager.web.request.CadetReq;
import com.drivers.manager.web.request.base.Request;
import com.drivers.manager.web.response.CadetResp;
import com.drivers.repository.CadetRepository;
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
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
@Service
@Transactional
public class CadetServiceImpl implements CadetService{
    @Autowired
    private CadetRepository repository;

    @Override
    public Cadet save(Cadet cadet) {
        return repository.save(cadet);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Cadet> findAllBySearch(final CadetReq request, Pageable pageable) {
        Page<Cadet> cadets = repository.findAll(getSpecification(request),pageable);
        if (cadets == null){
            cadets = new PageImpl<>(null,pageable,0);
        }
        return cadets;
    }

    private Specification<Cadet> getSpecification(final CadetReq req){
        return new Specification<Cadet>() {
            @Override
            public Predicate toPredicate(Root<Cadet> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Object, Object> cadetPay = root.join("cadetPay",JoinType.LEFT);
                Join<Object, Object> cadetCourse = root.join("cadetCourse",JoinType.LEFT);

                List<Predicate> list = new ArrayList<>();
                String name = req.getName();
                if (StringUtils.isNotBlank(name)){
                    Path<String> nameExp = root.get("name");
                    list.add(criteriaBuilder.like(nameExp,"%"+name+"%"));
                }

                String mobile = req.getMobile();
                if (StringUtils.isNotBlank(mobile)){
                    Path<String> mobileExp = root.get("mobile");
                    list.add(criteriaBuilder.like(mobileExp,"%"+mobile+"%"));
                }

                String weixinNum = req.getWeixinNum();
                if (StringUtils.isNotBlank(weixinNum)){
                    Path<String> weixinNumExp = root.get("weixinNum");
                    list.add(criteriaBuilder.like(weixinNumExp,"%"+weixinNum+"%"));
                }

                String idcardNum = req.getIdcardNum();
                if (StringUtils.isNotBlank(idcardNum)){
                    Path<String> idcardNumExp = root.get("idcardNum");
                    list.add(criteriaBuilder.like(idcardNumExp,"%"+idcardNum+"%"));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}
