package com.drivers.manager.web.resource;

import com.drivers.entity.Cadet;
import com.drivers.entity.Suggestion;
import com.drivers.manager.service.SuggestionService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.CadetReq;
import com.drivers.manager.web.request.SuggestionReq;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.CadetResp;
import com.drivers.manager.web.response.SuggestionResp;
import com.drivers.manager.web.response.base.Response;
import com.drivers.manager.web.response.base.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
@RestController
@RequestMapping(value = "/suggestions")
public class SuggestionResource extends BaseResource{
    @Autowired
    private SuggestionService service;

    @Validate
    @RequestMapping(value = "_search/suggestions", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Pager<SuggestionResp>> getByPage(SuggestionReq request, int limit, int offset, String sort, String order){
        Pageable pageable = this.toPageable(limit, offset, sort, order);
        Page<Suggestion> cadets = service.findAllBySearch(request,pageable);
        List<SuggestionResp> suggestionResps = new ArrayList<>();
        for(Suggestion suggestion : cadets.getContent()){
            SuggestionResp suggestionResp = new SuggestionResp();
            BeanUtils.copyProperties(suggestion,suggestionResp);
            if (suggestion.getCadet() != null){
                suggestionResp.setName(suggestion.getCadet().getName());
            }
            suggestionResps.add(suggestionResp);
        }

        Pager<SuggestionResp> result = new Pager<>(suggestionResps,cadets.getTotalElements());

        return new Response<>(result, StatusCode.OK);
    }
}
