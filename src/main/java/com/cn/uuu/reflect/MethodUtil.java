package com.cn.uuu.reflect;

import com.cn.uuu.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xin on 16-9-21.
 */
public class MethodUtil {
    public static void main(String[] args) {
        User user = new User();
        printInfoByMethodReflect(user);
    }

    public static void printInfoByMethodReflect(Object object){
        Class aClass=object.getClass();
        try {
            Method method = aClass.getMethod("say", new Class[]{String.class});
            method.invoke(object,"World");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
