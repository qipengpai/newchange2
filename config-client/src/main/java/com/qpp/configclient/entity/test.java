package com.qpp.configclient.entity;

public class test {

    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.setName("円");
        Line line=new Line();
        line.setName("先");
        line.doSomething(circle);
        line.doSomething(line);
    }
}
