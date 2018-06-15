package com.qpp.configclient.reflect;

import java.lang.reflect.Array;

public class ReflectArray {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Class<?> clazz = array.getClass().getComponentType();


        Object newArr = Array.newInstance(clazz, 15);

        int co = Array.getLength(array);

        System.arraycopy(array, 0, newArr, 0, co);
        for (int i:(int[]) newArr) {
            System.out.print(i+",");
        }
        System.gc();


        Class clazz2 = Class.forName("java.lang.String");


        Object array2 = Array.newInstance(clazz2, 10);


        Array.set(array2, 6, "hello world!");


        String str = (String)Array.get(array2, 6);
        System.out.println();
        System.out.println(str);
    }
    /**
     输出结果:
     1,2,3,4,5,6,7,8,9,0,0,0,0,0,0,
     hello world!
     */
}
