package com.cn.uuu.controller;



import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.uuu.util.JsonVo;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.uuu.pojo.User;
import com.cn.uuu.service.UserService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {
	/**日志服务*/
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/addUser.json", method = RequestMethod.POST)
	public JsonVo<String> addUser(User user){
		JsonVo<String> jsonVO=new JsonVo<String>();
		try {
			//校验用户名是否存在
			if (findUserByInfo(user).size()>=1) {
				jsonVO.setMessage("用户名已存在");
			}
			String userNo=userService.saveUser(user);
			if (!StringUtils.isEmpty(userNo)){
				jsonVO.setMessage("用户添加成功");
				jsonVO.setSuccess(true);
			}else{
				jsonVO.setSuccess(false);
				jsonVO.setMessage("用户添加不成功");
				logger.info("添加用户不成功:"+user);
			}
		}catch (Exception e){
			jsonVO.setSuccess(false);
			jsonVO.setMessage("用户添加不成功");
			logger.info("添加用户发生异常:"+user);
			e.printStackTrace();
		}
		return jsonVO;
	}


	/**
	 * 根据条件查询用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findUser.json", method = RequestMethod.GET)
	public JsonVo<List<User>> findUsers(User user){
		JsonVo<List<User>> jsonVO=new JsonVo<List<User>>();
		try{
			List<User> users=findUserByInfo(user);
			jsonVO.setSuccess(true);
			jsonVO.setMessage("条件查询成功");
			jsonVO.setResults(users);
		}catch (Exception e){
			jsonVO.setMessage("条件查询失败");
			jsonVO.setSuccess(false);
			e.printStackTrace();
		}
		return jsonVO;
	}

	//根据条件查找用户
	private List<User> findUserByInfo(User user){
		List<User> users=new ArrayList<User>();
		try{
			users=userService.findUser(user);
			if (users.size()<0){
				logger.error("条件搜索用户出错");
			}else{
				logger.info("共查询出"+users.size()+"条记录");
			}
		}catch (Exception e){
			logger.error("findUserByInfo发生异常");
			e.printStackTrace();
		}
		return users;
	}
}
