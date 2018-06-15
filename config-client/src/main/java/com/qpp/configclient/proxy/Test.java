package com.qpp.configclient.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MaotaiJiu maotaijiu = new MaotaiJiu();
        Wuliangye wu = new Wuliangye();
        Yuxi yuxi=new Yuxi();


        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiA(wu);
        InvocationHandler jingxiao3 = new GuitaiA(yuxi);
            /*loader 自然是类加载器
            interfaces 代码要用来代理的接口
            h 一个 InvocationHandler 对象*/
        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), jingxiao1);
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(Wuliangye.class.getClassLoader(),
                Wuliangye.class.getInterfaces(), jingxiao2);
        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(Yuxi.class.getClassLoader(),
                Yuxi.class.getInterfaces(), jingxiao3);
        dynamicProxy.mainJiu();
        dynamicProxy2.mainJiu();
        dynamicProxy3.sell();
        System.out.println("dynamicProxy class name:"+dynamicProxy.getClass().getName());
        System.out.println("dynamicProxy1 class name:"+dynamicProxy2.getClass().getName());
        System.out.println("dynamicProxy3 class name:"+dynamicProxy3.getClass().getName());   }
}
