package com.chenpl.dog;

public class dog {
    public String name;
    public int age;

    public dog(String var1, int var2) {
        this.name = var1;
        this.age = var2;
    }

    public String getdata() {
        return "name: " + this.name + ", age: " + this.age;
    }
}
