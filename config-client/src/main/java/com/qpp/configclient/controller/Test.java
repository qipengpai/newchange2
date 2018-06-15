package com.qpp.configclient.controller;

@TestAnnotation(id = 5,msg = "亓先生")
public class Test {
    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation){
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:"+Integer.toHexString(testAnnotation.id()));
            System.out.println("id:"+Integer.toBinaryString(testAnnotation.id()));
            System.out.println("id:"+Integer.toOctalString(testAnnotation.id()));
            System.out.println("msg:"+testAnnotation.msg());
            System.out.println(Integer.TYPE);
        }

    }
}
