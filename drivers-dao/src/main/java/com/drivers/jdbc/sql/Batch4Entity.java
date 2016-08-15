package com.drivers.jdbc.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:实体batch操作基类
 * Description: 在Insert和Update的基础上进行封装
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 * @author fengwen
 * @version 1.0 2015年6月26日
 */
public class Batch4Entity<T> {
	
	protected Insert baseInsert = null;
	protected Update baseUpdate = null;
	
	protected boolean isFilterNull;
	
	
	
	/**
	 * 获取调用spring jdbc batch api所需的List<Object[]>参数
	 * @param data
	 * @return
	 */
	protected List<Object[]> getInsertParams(List<T> data){
		List<Object[]> paramList = new ArrayList<Object[]>();
		for(T t:data){
			paramList.add(getInertParams(t));
		}
		return paramList;
	}

	private Object[] getInertParams(T t) {
		Insert insert = new Insert(t, isFilterNull);
		insert.remove("id");
		insert.remove("server_create_time");
		insert.remove("server_update_time");
		return insert.getParams();
	}
	
	/**
	 * 获取调用spring jdbc batch api所需的List<Object[]>参数
	 * @param data
	 * @return
	 */
	protected List<Object[]> getUpdateParams(List<T> data,String where,Object... params){
		List<Object[]> paramList = new ArrayList<Object[]>();
		for(T t:data){
			Update update = new Update(t, isFilterNull);
			update.setWhere(where, params);
			paramList.add(update.getParams());
		}
		return paramList;
	}

	

}
