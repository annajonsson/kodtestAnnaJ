package com.kodtestannaj.kodtestapi.model;

public class Person {
    private Long id;
    private String name;
    private int age;
    private String email;

    public Person(Long id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String email() {
        return email;
    }

}
