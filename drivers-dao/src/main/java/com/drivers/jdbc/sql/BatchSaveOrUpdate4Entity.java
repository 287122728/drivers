package com.drivers.jdbc.sql;

import com.drivers.StringUtil;
import com.drivers.jdbc.annotations.TableEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title:针对实体的批量saveOrUpdate
 * Description:因为使用了底层SQL特性 所以暂时只能针对MYSQL
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 * @author fengwen
 * @version 1.0 2015年6月26日
 */
public class BatchSaveOrUpdate4Entity<T> extends Batch4Entity<T>{
	
	
	private static final String ON_DUPLICATE_KEY ="ON DUPLICATE KEY";
	
	private String tableName;
	
	public BatchSaveOrUpdate4Entity(List<T> data,Class<T> clazz)  {
		if(!clazz.isAnnotationPresent(TableEntity.class)){
			throw new NullPointerException(clazz+" did not has a annotation @TableEntity");
		}
		TableEntity tableEntity = clazz.getAnnotation(TableEntity.class);
		init(data, isFilterNull, tableEntity.value());
	}
	
	public BatchSaveOrUpdate4Entity(List<T> data,String tableName)  {
		this(data, true,tableName);
	}
	
	public BatchSaveOrUpdate4Entity(List<T> data,boolean isFilterNull,String tableName) {
		init(data, isFilterNull, tableName);
	}
	
	private void init(List<T> data,boolean isFilterNull,String tableName){
		if(data.size()==0){
//			throw new BizException("size of list data can not be 0");
		}
		super.isFilterNull = isFilterNull;
		baseInsert = new Insert(data.get(0),isFilterNull);
		baseUpdate = new Update(data.get(0),isFilterNull);
		this.tableName = tableName;
	}
	
	/**
	 * 使用mysql底层特性 目的是生成类似下面的SQL
	 * insert into trade(brand_identy, creator_name, uuid) values(?, ?, ?) ON DUPLICATE KEY update   brand_identy=? , creator_name=? 
	 * 此SQL的作用是如果uuid上面有唯一索引那么则会检测uuid是否存在 如果不存在则添加
	 * 如果存在 则相当于执行 update trade set brand_identy=? , creator_name=? where uuid=?
	 * @param updateWhere
	 * @return
	 */
	public String toSql(String updateWhere){
		baseUpdate.setWhere(updateWhere, "");//这里的第2个参数只为生成sql
		String sql = baseInsert.toSQL();
		sql += " "+ON_DUPLICATE_KEY+" ";
		String updateSql = baseUpdate.toSQL();
		updateSql = StringUtil.replaceFirst(updateSql, tableName, "");
		updateSql = StringUtil.replaceFirst(updateSql, "set", "");
//		updateSql = StringUtil.replaceFirst(updateSql, updateWhere, "");
		updateSql = updateSql.substring(0, updateSql.lastIndexOf("where"));
		sql += updateSql;
		return sql;
	}
	
	
	public List<Object[]> getParamList(List<T> data,String updateWhere,Object... params) {
		List<Object[]> paramList = new ArrayList<Object[]>();
		//循环遍历 将insert和update生成的问号对应的值进行合并
		for(T t:data){
			Object[] insertParams = new Insert(t, isFilterNull).getParams();
			int oldInsertParamsLen = insertParams.length;//扩容前Insert产生的数组的长度
			Update update = new Update(t, isFilterNull);
			update.setWhere(updateWhere, "");//这里的第2个参数只为通过内部验证
			Object[] updateParams = update.getParams();
			//对insertParams进行扩容 然后将updateParams的内容进行合并  updateParams.length-1的目的是不要最后一个元素即setWhere生成的xx=? 问号对应属性的值
			insertParams =Arrays.copyOf(insertParams, insertParams.length+(updateParams.length-1));
			System.arraycopy(updateParams, 0, insertParams, oldInsertParamsLen, updateParams.length-1);
			paramList.add(insertParams);
		}
		return paramList;
	}
	
	
	
//	public static void main(String[] args) throws Exception {
//		List<Trade> data = new ArrayList<Trade>();
//		Trade trade = new Trade();
//		trade.setBrandIdenty(10L);
//		trade.setCreatorName("creatorName");
//		trade.setUuid(UUID.randomUUID().toString());
//		data.add(trade);
//		String updateWhere = "uuid=?";
//		BatchSaveOrUpdate4Entity<Trade> bi = new BatchSaveOrUpdate4Entity<Trade>(data,"trade");
//		System.err.println(bi.toSql(updateWhere)+"*");
//		bi.getParamList(data, updateWhere, trade.getUuid());
//		
//	}
}
