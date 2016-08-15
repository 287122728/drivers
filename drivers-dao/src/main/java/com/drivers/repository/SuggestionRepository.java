package com.drivers.repository;

import com.drivers.entity.Suggestion;
import com.drivers.repository.base.JpaSpecificationPagingRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
public interface SuggestionRepository extends JpaSpecificationPagingRepository<Suggestion, Long>,SuggestionDao {

    @Modifying
    @Query("update Suggestion set dataStatus = ?0")
    public Integer invalid(Long id);
}
