package com.xinguoren.coolpen.cloud.web.spring.pojo;

/**
 * Created by Lenovo on 2017/2/21.
 */
public class Person {
    private String name;
    private String tel;

    public Person(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
    public void introduce(){
        System.out.println("Hi,I am " + name);
    }


    public static void main(String[] args) {
        Person person = new Person("高旭刚","15135158097");
        person.introduce();
    }
}

