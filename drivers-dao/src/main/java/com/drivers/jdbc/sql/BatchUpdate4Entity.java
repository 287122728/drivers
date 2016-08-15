package com.drivers.jdbc.sql;

import java.util.List;

/**
 * Title:批量修改实体
 * Description: 
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 * @author fengwen
 * @version 1.0 2015年6月26日
 */
public class BatchUpdate4Entity<T> extends Batch4Entity<T>{
	
	public BatchUpdate4Entity(List<T> data)  {
		this(data, true);
	}
	
	public BatchUpdate4Entity(List<T> data,boolean isFilterNull) {
		if(data.size()==0){
//			throw new BizException("size of list data can not be 0");
		}
		super.isFilterNull = isFilterNull;
		baseUpdate = new Update(data.get(0),isFilterNull);
	}
	
	

	//获取生成的sql
	public String toSql(String updateWhere){
		baseUpdate.setWhere(updateWhere, "");//这里的第2个参数只为生成sql
		return baseUpdate.toSQL();
	}
	

	//获取 spring jdbc batch api 需要的List<Object[]>参数
	public List<Object[]> getParamList(List<T> data,String where,Object... params) {
		return getUpdateParams(data,where,params);
	}
	

}
