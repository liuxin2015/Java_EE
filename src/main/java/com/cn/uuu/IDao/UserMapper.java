package com.cn.uuu.IDao;

import com.cn.uuu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 创建用户
     * @param user
     * @return
     */
    @Transactional
    String saveUser(User user);

    /**
     * 查询匹配用户
     * @param user
     * @return
     */
    List<User> findUser(User user);

}