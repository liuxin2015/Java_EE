package com.cn.uuu.service;

import java.util.List;

import com.cn.uuu.pojo.Message;

public interface MessageService {
	/**
	 * 查询所有的信息
	 * @return
	 */
   public List<Message> queryAllMessage();
}
