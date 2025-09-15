package com.annguyen.supperapp.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity // map 1 class thanh table
@Table(name = "Lectuters")// ten table co the khac ten class
public class Lectuter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// la tu generate id tu dong tang tu 1,2,3...
    @Column(name = "Id")
    private long id;
    @Column(name = "Name", nullable = false, length = 50, columnDefinition = "NVARCHAR(50)")
    private String name;
    @Column(name = "Yob", nullable = false)
    private int yob;
    @Column(name = "Salary")
    private double salary;

    //lombok de loai boiler plate code
    //bat buoc phai co contructor rong, contructor full tham so
    //getter, setter, toString()
    public Lectuter() {
    }
    public Lectuter( String name, int yob, double salary) {
        this.name = name;
        this.yob = yob;
        this.salary = salary;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Lectuter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", salary=" + salary +
                '}';
    }
}

