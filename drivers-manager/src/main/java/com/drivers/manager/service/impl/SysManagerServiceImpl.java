package com.drivers.manager.service.impl;

import com.drivers.entity.SysManager;
import com.drivers.manager.service.SysManagerService;
import com.drivers.manager.web.request.SysManagerReq;
import com.drivers.manager.web.request.base.Request;
import com.drivers.repository.SysManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
 * @version 1.0 2016/8/9
 */
@Service
@Transactional
@Slf4j
public class SysManagerServiceImpl implements SysManagerService {

    @Autowired
    private SysManagerRepository repository;

    public SysManager save(SysManager sysManager){
        return repository.save(sysManager);
    }
    @Transactional(readOnly = true)
    @Override
    public Page<SysManager> findByPageSearch(SysManagerReq request, Pageable pageable) {
        log.debug("Request to get search SysManager by Pageable");
        Page<SysManager> topics = repository.findAll(getSpecification(request),pageable);
        return topics;
    }

    private Specification<SysManager> getSpecification(final SysManagerReq sysManagerReq){
        return new Specification<SysManager>() {
            @Override
            public Predicate toPredicate(Root<SysManager> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();

//                String search = sysManager.getSearch();
//                if (StringUtils.isNotBlank(search)){
//                    Path<String> nameExp = root.get("name");
//                    list.add(criteriaBuilder.like(nameExp,"%"+search+"%"));
//                    Predicate[] p = new Predicate[list.size()];
//                    return criteriaBuilder.and(list.toArray(p));
//                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}
