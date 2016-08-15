/**
 * 
 */
package com.drivers;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author  liangb
 * @date    2015-2-28 上午11:17:53
 * @version 1.0
 */
public class StringUtil extends StringUtils {
	
	public static int[] split2IntArray(String str, String separatorChars){
		String [] strArray = split(str, separatorChars);
		if(strArray != null && strArray.length > 0){
			int [] intArray = new int [strArray.length];
			for (int i = 0; i < intArray.length; i++) {
				intArray[i] = Integer.parseInt(strArray[i]);
			}
			return intArray;
		}
		return null;
	}
	
	public static boolean isBlank(Long arg0){
		return arg0 == null || arg0 <= 0;
	}
	
	public static boolean isNotBlank(Long arg0){
		return arg0 == null ? false : arg0 > 0;
	}
	
	public static boolean isBlank(Integer arg0){
		return arg0 == null ? true : arg0 <= 0;
	}
	
	public static boolean isNotBlank(Integer arg0){
		return arg0 == null ? false : arg0 > 0;
	}
	
	/**
	 * added by fw 2015-7-3 
	 * 将source第1次出现的pattern替换为replaceTo
	 * @param source
	 * @param pattern
	 * @param replaceTo
	 * @return
	 */
	public static String replaceFirst(String source,String pattern,String replaceTo){
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		return m.replaceFirst(replaceTo);
	}
}
