package com.drivers.manager.service.impl;

import com.drivers.entity.Cadet;
import com.drivers.entity.Suggestion;
import com.drivers.manager.service.SuggestionService;
import com.drivers.manager.web.request.CadetReq;
import com.drivers.manager.web.request.SuggestionReq;
import com.drivers.repository.SuggestionRepository;
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
 * Created by xhuji on 2016/8/11.
 */
@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    private SuggestionRepository repository;

    @Override
    public Suggestion save(Suggestion suggestion) {
        return repository.save(suggestion);
    }

    @Override
    public Integer invalid(Long id) {
        return repository.invalid(id);
    }

    @Override
    public void delete(Long id) {

    }
    @Transactional(readOnly = true)
    @Override
    public Suggestion findOne(Long id) {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Suggestion> findAll() {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public Page<Suggestion> findAll(Pageable pageable) {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public Page<Suggestion> findAllBySearch(SuggestionReq req, Pageable pageable) {
        Page<Suggestion> suggestions = repository.findAll(getSpecification(req),pageable);
        if (suggestions == null){
            suggestions = new PageImpl<>(null,pageable,0);
        }
        return suggestions;
    }

    private Specification<Suggestion> getSpecification(final SuggestionReq req){
        return new Specification<Suggestion>() {
            @Override
            public Predicate toPredicate(Root<Suggestion> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Object, Object> cadetPay = root.join("cadet",JoinType.LEFT);
                List<Predicate> list = new ArrayList<>();
                String name = req.getName();
                if (StringUtils.isNotBlank(name)){
                    Path<String> nameExp = cadetPay.get("name");
                    list.add(criteriaBuilder.like(nameExp,"%"+name+"%"));
                }

                String mobile = req.getMobile();
                if (StringUtils.isNotBlank(mobile)){
                    Path<String> mobileExp = cadetPay.get("mobile");
                    list.add(criteriaBuilder.like(mobileExp,"%"+mobile+"%"));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}
