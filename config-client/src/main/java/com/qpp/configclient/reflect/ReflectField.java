package com.qpp.configclient.reflect;

import java.lang.reflect.Field;

public class ReflectField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.qpp.configclient.reflect.Student");
        Student st= (Student) clazz.newInstance();
        Field ageField = clazz.getField("age");
        ageField.set(st,18);
        Field nameField = clazz.getField("name");
        nameField.set(st,"Lily");


        Field descField = clazz.getDeclaredField("desc");
        descField.set(st,"I am student");
        Field scoreField = clazz.getDeclaredField("score");

        scoreField.setAccessible(true);
        scoreField.set(st,88);
        System.out.println(st.toString());

        System.out.println(scoreField.get(st));

        Field field = clazz.getField("age");
        System.out.println("field:"+field);


        Field fields[] = clazz.getFields();
        for (Field f:fields) {
            System.out.println("f:"+f+"--------"+f.getDeclaringClass());
        }

        System.out.println("================getDeclaredFields====================");

        Field fields2[] = clazz.getDeclaredFields();
        for (Field f:fields2) {
            System.out.println("f2:"+f+"--------"+f.getDeclaringClass());
        }

        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("field2:"+field2);


    }
    /**
     输出结果:
     field:public int reflect.Person.age
     f:public java.lang.String reflect.Student.desc
     f:public int reflect.Person.age
     f:public java.lang.String reflect.Person.name

     ================getDeclaredFields====================
     f2:public java.lang.String reflect.Student.desc
     f2:private int reflect.Student.score
     field2:public java.lang.String reflect.Student.desc
     */

}
