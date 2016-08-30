package test.batis;

import javax.annotation.Resource;

import org.apache.log4j.Logger;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.cn.uuu.pojo.User;
import com.cn.uuu.service.UserService;
import com.cn.uuu.service.impl.UserServiceImpl;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

public class TestMyBatis {
	
	
    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Autowired
    private UserService userService;



}
