package com.guliang.guava.nhash;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
class Person {
    final int id;
    final String firstName;
    final  String lastName;
    final int birthYear;

    public Person(int id, String firstName, String lastName, int birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
