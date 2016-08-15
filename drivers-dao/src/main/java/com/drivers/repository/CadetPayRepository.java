package com.drivers.repository;

import com.drivers.entity.Cadet;
import com.drivers.entity.CadetPay;
import com.drivers.repository.base.JpaSpecificationPagingRepository;
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
public interface CadetPayRepository extends JpaSpecificationPagingRepository<CadetPay, Long> {

    @Query("select cadet from Cadet cadet, CadetPay cadetPay where cadetPay.id = ?1")
    public Cadet findOneById(Long id);
}
