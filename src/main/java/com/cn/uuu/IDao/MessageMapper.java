package com.cn.uuu.IDao;


import com.cn.uuu.pojo.Message;

import java.util.List;

public interface MessageMapper {
	/**
	 * 查询所有的消息
	 * @return
	 */
	public List<Message> queryAllMessage();
}
