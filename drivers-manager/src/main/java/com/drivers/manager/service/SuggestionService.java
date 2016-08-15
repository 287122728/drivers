package com.drivers.manager.service;

import com.drivers.entity.Suggestion;
import com.drivers.manager.web.request.SuggestionReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xhuji on 2016/8/11.
 */
public interface SuggestionService {

    public Suggestion save(Suggestion suggestion);

    public void delete(Long id);

    public Integer invalid(Long id);

    public Suggestion findOne(Long id);

    public List<Suggestion> findAll();

    public Page<Suggestion> findAll(Pageable pageable);

    public Page<Suggestion> findAllBySearch(final SuggestionReq topicReq, Pageable pageable);
}
