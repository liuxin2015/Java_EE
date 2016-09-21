package com.cn.uuu.reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin on 16-9-21.
 */
public class DoList {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<String> strs=new ArrayList<String>();
        strs.add("hello");
        addIntegerIntoStringList(strs);
    }
    public static void addIntegerIntoStringList(List<String> strs) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<List> listClass = List.class;
        Method method=listClass.getMethod("add",Object.class);
        method.invoke(strs,new Integer(1));
        System.out.println(strs);
    }
}
