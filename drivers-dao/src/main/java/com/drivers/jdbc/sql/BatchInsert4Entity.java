package com.drivers.jdbc.sql;

import java.util.List;

/**
 * Title:批量添加实体
 * Description: 
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 * @author fengwen
 * @version 1.0 2015年6月25日
 */
public class BatchInsert4Entity<T> extends Batch4Entity<T>{
	
	public BatchInsert4Entity(List<T> data)  {
		this(data, true);
	}
	
	public BatchInsert4Entity(List<T> data,boolean isFilterNull) {
		if(data.size()==0){
//			throw new BizException("size of list data can not be 0");
		}
		super.isFilterNull = isFilterNull;
		baseInsert = new Insert(data.get(0),isFilterNull);
        baseInsert.remove("id");
		baseInsert.remove("server_create_time");
		baseInsert.remove("server_update_time");
	}
	

	//获取生成的sql
	public String toSql(){
		return baseInsert.toSQL();
	}

	//获取 spring jdbc batch api 需要的List<Object[]>参数
	public List<Object[]> getParamList(List<T> data) {
		return getInsertParams(data);
	}
	
}
