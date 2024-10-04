package com.example.prac02;

import java.util.Date;

public class Staff {
    private String id;
    private String fullName;
    private String birthDate;
    private String salary;

    public Staff(String id, String fullName, String birthDate, String salary) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSalary() {
        return salary;
    }
}