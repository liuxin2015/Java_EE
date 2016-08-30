package com.cn.uuu.service;

import com.cn.uuu.pojo.User;

import java.util.List;

public interface UserService {
	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
	String saveUser(User user);
	/**
	 * 查找匹配用户
	 * @param user
	 * @return
	 */
	List<User> findUser(User user);

}  
