package org.apitest.entity;

import lombok.Data;

@Data
public class User {

    int Id;
    String name;
    int age;

    public User(int id, String name, int age) {
        Id = id;
        this.name = name;
        this.age = age;
    }


    public User() {

    }
}
