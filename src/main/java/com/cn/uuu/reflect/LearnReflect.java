package com.cn.uuu.reflect;

import com.cn.uuu.pojo.User;

/**
 * Created by xin on 16-9-20.
 */
public class LearnReflect {
    public static void main(String[] args) {
        User user=new User();
        //类的三种实例
        Class class1=User.class;
        Class class2=user.getClass();
        Class class3=null;
        try {
            class3=Class.forName("com.cn.uuu.pojo.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        boolean instance = class3.isInstance(user);
        System.out.println(instance);

        try {
            user=(User)class3.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(class1==class2);
        user.print();
    }
}
