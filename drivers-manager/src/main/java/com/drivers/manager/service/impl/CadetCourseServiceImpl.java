package com.drivers.manager.service.impl;

import com.drivers.entity.Cadet;
import com.drivers.manager.service.CadetCourseService;
import com.drivers.manager.web.request.CadetCourseReq;
import com.drivers.manager.web.request.CadetPayReq;
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
 * Created by xhuji on 2016/8/13.
 */
@Service
@Transactional
public class CadetCourseServiceImpl implements CadetCourseService {

    @Autowired
    private CadetRepository cadetRepository;
    @Override
    public Page<Cadet> findAllBySearch(CadetCourseReq request, Pageable pageable) {
        Page<Cadet> cadets = cadetRepository.findAll(getSpecification(request),pageable);
        if (cadets == null){
            cadets = new PageImpl<Cadet>(null,pageable,0);
        }
        return cadets;
    }

    private Specification<Cadet> getSpecification(final CadetCourseReq req) {
        return new Specification<Cadet>() {
            @Override
            public Predicate toPredicate(Root<Cadet> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Object, Object> cadetPay = root.join("cadetPay",JoinType.LEFT);

                List<Predicate> list = new ArrayList<>();
                String name = req.getName();
                if (StringUtils.isNotBlank(name)) {
                    Path<String> nameExp = root.get("name");
                    list.add(criteriaBuilder.like(nameExp, "%" + name + "%"));
                }

                String mobile = req.getMobile();
                if (StringUtils.isNotBlank(mobile)) {
                    Path<String> mobileExp = root.get("mobile");
                    list.add(criteriaBuilder.like(mobileExp, "%" + mobile + "%"));
                }

                String weixinNum = req.getWeixinNum();
                if (StringUtils.isNotBlank(weixinNum)) {
                    Path<String> weixinNumExp = root.get("weixinNum");
                    list.add(criteriaBuilder.like(weixinNumExp, "%" + weixinNum + "%"));
                }

                String idcardNum = req.getIdcardNum();
                if (StringUtils.isNotBlank(idcardNum)) {
                    Path<String> idcardNumExp = root.get("idcardNum");
                    list.add(criteriaBuilder.like(idcardNumExp, "%" + idcardNum + "%"));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}
