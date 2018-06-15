package com.qpp.configclient.enums;

public class test {
    public static void main(String[] args) {
        System.out.println(convert(23,2));
//        System.out.println(power(8,2));
    }

    private static int convert(int n, int i) {//n为输入的八进制数，i为位数
        int temp[] = new int[i];
        int result = 0;
        for(int j=0;j < i;j++){
            temp[j] = (n/power(10,i-j-1))%power(10,1);
            result += temp[j]*power(8,i-j-1);
//            System.out.print(n + " " + temp[j] + " " + power(10,i-j-1) + " " + power(10,j) + "\n");
        }
//        System.out.println();
        return result;
    }

    private static int power(int i, int j) {
        int temp = 1;
        for(int k=0;k<j;k++){
            temp *= i;
        }
        return temp;
    }
}
