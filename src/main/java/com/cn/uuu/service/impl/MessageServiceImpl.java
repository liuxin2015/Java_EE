package com.cn.uuu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.uuu.IDao.MessageMapper;
import com.cn.uuu.pojo.Message;
import com.cn.uuu.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper messageMapper;

	@Transactional(readOnly=true)
	public List<Message> queryAllMessage() {
		List<Message> messages=this.messageMapper.queryAllMessage();
		return messages;
	} 
}
