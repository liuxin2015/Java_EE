package com.cn.uuu.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.configuration.*;

public class ConnectAPI {
/*	String httpUrl = "http://apis.baidu.com/apistore/weatherservice/weather";
	String httpArg = "citypinyin=beijing";*/
	
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 * @throws ConfigurationException 
	 */
	public static String request(String httpUrl, String httpArg) throws ConfigurationException {

		String filePath = ConnectAPI.class.getClassLoader().getResource("Api.properties").getPath();    //获取配置文件
		Configuration config = new PropertiesConfiguration(filePath);  
	    String api_key = config.getString("api_value");   //得到key
	    
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("apikey",  api_key);
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
