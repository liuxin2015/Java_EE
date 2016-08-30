package com.cn.uuu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.uuu.IDao.UserMapper;
import com.cn.uuu.pojo.User;
import com.cn.uuu.service.UserService;
import org.springframework.transaction.annotation.Transactional;


@Service
	public class UserServiceImpl implements UserService {

		Logger logger = Logger.getLogger(UserServiceImpl.class);

		@Autowired
		private UserMapper userMapper;

		/*
         * (non-Javadoc)
         *
         * @see com.notebook.service.UserService#saveUser(com.notebook.model.User)
         */
		@Transactional
		public String saveUser(User user) {
			return userMapper.saveUser(user);
		}

         /**
          * 根据条件查询用户
          * @param user
          * @return
          */
         @Transactional(readOnly = true)
        public List<User> findUser(User user) {
            return userMapper.findUser(user);
        }


}

