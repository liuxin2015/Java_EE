package com.cn.uuu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.uuu.pojo.Message;
import com.cn.uuu.service.MessageService;
import com.cn.uuu.util.JsonVo;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageSerive;

	/**
	 * 获取所有的消息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllMessage.json", method = RequestMethod.POST)
	public JsonVo<List<Message>> queryMessage() {
		JsonVo<List<Message>> jsonVo = new JsonVo<List<Message>>();
		try {
			List<Message> messages = this.messageSerive.queryAllMessage();
			jsonVo.setMessage("查询信息成功");
			jsonVo.setResults(messages);
			jsonVo.setSuccess(true);
		} catch (Exception e) {
			jsonVo.setMessage("消息查询失败");
			jsonVo.setSuccess(false);
			e.printStackTrace();
		}
		return jsonVo;
	}
}
