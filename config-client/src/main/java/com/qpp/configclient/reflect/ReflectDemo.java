package com.qpp.configclient.reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ReflectDemo implements Serializable {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = null;

        clazz = Class.forName("com.qpp.configclient.reflect.User");

        User user = (User) clazz.newInstance();
        user.setAge(20);
        user.setName("Rollen");
        System.out.println(user);
        System.out.println("--------------------------------------------");

        Constructor cs1 = clazz.getConstructor(String.class);

        User user1 = (User) cs1.newInstance("xiaolong");
        user1.setAge(22);
        System.out.println("user1:" + user1.toString());

        System.out.println("--------------------------------------------");


        Constructor cs2 = clazz.getDeclaredConstructor(int.class, String.class);

        cs2.setAccessible(true);

        User user2 = (User) cs2.newInstance(25, "lidakang");
        System.out.println("user2:" + user2.toString());

        System.out.println("--------------------------------------------");


        Constructor<?> cons[] = clazz.getDeclaredConstructors();

        for (int i = 0; i < cons.length; i++) {

            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("构造函数[" + i + "]:" + cons[i].toString());
            System.out.print("参数类型[" + i + "]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
        Constructor cs3=clazz.getDeclaredConstructor(int.class,String.class);

        System.out.println("-----getDeclaringClass-----");
        Class uclazz=cs3.getDeclaringClass();
//Constructor对象表示的构造方法的类
        System.out.println("构造方法的类:"+uclazz.getName());

        System.out.println("-----getGenericParameterTypes-----");
//对象表示此 Constructor 对象所表示的方法的形参类型
        Type[] tps=cs3.getGenericParameterTypes();
        for (Type tp:tps) {
            System.out.println("参数名称tp:"+tp);
        }
        System.out.println("-----getParameterTypes-----");
//获取构造函数参数类型;
        Class<?> clazzs[] = cs3.getParameterTypes();
        for (Class claz:clazzs) {
            System.out.println("参数名称:"+claz.getName());
        }
        System.out.println("-----getName-----");
//以字符串形式返回此构造方法的名称
        System.out.println("getName:"+cs3.getName());

        System.out.println("-----getoGenericString-----");
//返回描述此 Constructor 的字符串，其中包括类型参数。
        System.out.println("getoGenericString():"+cs3.toGenericString());
    }


}