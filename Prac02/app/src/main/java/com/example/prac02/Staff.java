package com.example.prac02;

import java.util.Date;

public class Staff {
    private String id;
    private String name;
    private Date birth_date;
    private Double salary;

    public Staff(String id, String name, Date birth_date, Double salary) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
