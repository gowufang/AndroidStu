package com.project.ics.d1101listviewtest;

/**
 * Created by Administrator on 2017/11/1.
 * Email:gowufang@gmail.com
 */

public class Item {
    private String name;
    private String age;
    private String phone;

    public Item(String name,String age,  String phone) {
        this.age = age;
        this.name = name;
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
