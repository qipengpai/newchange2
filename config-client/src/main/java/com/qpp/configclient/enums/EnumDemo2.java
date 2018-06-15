package com.qpp.configclient.enums;

import java.util.Arrays;

public class EnumDemo2 {
    public static void main(String[] args) {
        //正常使用
        Day[] ds=Day.values();
//向上转型Enum
        Enum e = Day.MONDAY;
//无法调用,没有此方法//e.values();//获取class对象引用
        Class<?> clasz = e.getDeclaringClass();
        if(clasz.isEnum()) {
            Day[] dsz = (Day[]) clasz.getEnumConstants();
            System.out.println("dsz:"+ Arrays.toString(dsz));
        }

/**
 输出结果:
 dsz:[MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
 */
    }
}
