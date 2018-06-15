package com.qpp.configclient.entity;

public class Shape {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void doSomething(Shape shape){
        System.out.println(shape.getName()+"henj86");
    }

}
