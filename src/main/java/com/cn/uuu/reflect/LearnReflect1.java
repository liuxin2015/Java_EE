package com.cn.uuu.reflect;

import com.cn.uuu.pojo.Message;
import com.mysql.jdbc.StringUtils;

/**
 * Created by xin on 16-9-20.
 */
public class LearnReflect1 {
    public static void main(String[] args) {
        new LearnReflect1().say("com.cn.uuu.pojo.Message");
    }
    public void say(String classForName){
        if (!StringUtils.isNullOrEmpty(classForName)) {
            try {
                Class aClass=Class.forName(classForName);
                ReflectInterface inter=(ReflectInterface) aClass.newInstance();
                if (inter != null) {
                 inter.say("111");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
