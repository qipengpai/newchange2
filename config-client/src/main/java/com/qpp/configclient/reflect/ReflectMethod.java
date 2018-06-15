package com.qpp.configclient.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class clazz = Class.forName("com.qpp.configclient.reflect.Circle");


        Method method = clazz.getMethod("draw", int.class, String.class);

        System.out.println("method:" + method);


        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("m::" + m);
        }

        System.out.println("=========================================");


        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1::" + method1);

        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println("m1::" + m);
        }
        Circle circle = (Circle) clazz.newInstance();
        Method method2 = clazz.getMethod("draw",int.class,String.class);

        method2.invoke(circle,15,"圈圈");


        Method method3 = clazz.getDeclaredMethod("drawCircle");

        method3.setAccessible(true);
        method3.invoke(circle);


        Method method4 =clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method4.invoke(circle);
        System.out.println("count:"+count);

/**
 输出结果:
 draw 圈圈,count=15
 drawCircle
 count:100
 */
    }
}
/**
 输出结果:
 method:public void reflect.Shape.draw(int,java.lang.String)

 m::public int reflect.Circle.getAllCount()
 m::public void reflect.Shape.draw()
 m::public void reflect.Shape.draw(int,java.lang.String)
 m::public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
 m::public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
 m::public final void java.lang.Object.wait() throws java.lang.InterruptedException
 m::public boolean java.lang.Object.equals(java.lang.Object)
 m::public java.lang.String java.lang.Object.toString()
 m::public native int java.lang.Object.hashCode()
 m::public final native java.lang.Class java.lang.Object.getClass()
 m::public final native void java.lang.Object.notify()
 m::public final native void java.lang.Object.notifyAll()

 =========================================
 method1::private void reflect.Circle.drawCircle()

 m1::public int reflect.Circle.getAllCount()
 m1::private void reflect.Circle.drawCircle()
 */

