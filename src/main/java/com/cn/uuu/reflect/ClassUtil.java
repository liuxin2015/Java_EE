package com.cn.uuu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xin on 16-9-21.
 */
public class ClassUtil {
    /**
     * 打印类信息
     * @param object
     */
    public static void printClassMessage(Object object){
        Class objectClass=object.getClass();
        System.out.println("此类为"+objectClass.getName());
        //得到此类中所有的方法
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method:methods) {
            //获取此方法的返回值类型
            Class<?> returnType = method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String parameterTypeName="";
            for (int i = 0; i < parameterTypes.length; i++) {
                parameterTypeName=parameterTypes[i].getName();
            }
            System.out.println("此类的方法有："+method.getName()+"----->"+returnType.getName()+"----->"+parameterTypeName);
        }
    }


    /**
     * 获取构造函数信息
     */
    public static void printConMessage(Object object){
        //获取类类型
        Class<?> aClass = object.getClass();
        System.out.println("类名为："+aClass.getName());
        //过去构造所有的构造函数
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor constructor:constructors) {
            //获取构造函数名称
            String constructorName = constructor.getName();
            Class[] constructorParameterTypes = constructor.getParameterTypes();
            String constructorParameterTypeName="";
            for (int i = 0; i < constructorParameterTypes.length; i++) {
                //获取返回值名称
                constructorParameterTypeName=constructorParameterTypes.getClass().getName();
            }
            System.out.println("构造函数名称："+constructorName+"---->"+constructorParameterTypeName);
        }
    }

    /**
     * 获取常量信息
     */
    public static void printFieldMessage(Object object){
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getFields();
        for (Field field:fields) {
            System.out.println("常量类型"+field.getType().getName()+"---->"+field.getName());
        }
    }


    public static void main(String[] args) {
        ClassUtil.printFieldMessage(new Integer(1));
    }
}
