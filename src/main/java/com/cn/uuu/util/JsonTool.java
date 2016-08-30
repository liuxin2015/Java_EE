package com.cn.uuu.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * json与对象转化的工具类
 * @author ck
 *
 */
public class JsonTool {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 把对象转换成JSON字符串
	 * @param value
	 * @return
	 * @throws JsonProcessingException 
	 */
	public static String createJsonString(Object value) throws Exception {
		return objectMapper.writeValueAsString(value);
	}
	
	/**
	 * JSON解析成实体对象
	 * @param jsonString
	 * @param cls 实体对象Class类
	 * @return
	 */
 	public static <T> T json2povo(String jsonString, Class<T> cls) {
        T t = null;
        try{
            t = objectMapper .readValue(jsonString, cls);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return t;
    }
	
 	/**
 	 * JSON解析成对象List
 	 * @param jsonString
 	 * @param cls 实体对象Class类
 	 * @return
 	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> json2list(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try{
            list = objectMapper .readValue(jsonString, List.class);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return list;
    }

}
