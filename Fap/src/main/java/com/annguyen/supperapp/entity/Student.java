package com.annguyen.supperapp.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;
//

// CLASS nay se dc khai de
// anh xa/ bien doi tuong duong, dc Map thanh table tuong ung
@Entity
@Table(name = "Student") // neu khong co khai bao nay thi mac dinh lay ten class
// lam ten table
public class Student {
    @Id
    @Column(name = "Id") // neu khong co khai bao nay thi mac dinh lay feild lam cot
    private  String id;// CAMEL CASE, id tu nhao (id tu tang tinh sau
    @Nationalized // thieu khai bao nay String -> varchar ko luu tieng viet dc -> de string bien thanh nvarchar thi can them khai bao @nationalized
    //neu ko lam ,, tieng viet se ra dau hoi cham ? thay the cho dau tieng viet

    @Column(name = "Name", nullable = false, length = 50)
    private  String name;

    @Column(name = "Yob", nullable = false)
    private  int yob;

    @Column(name = "Gpa", nullable = false)
    private  double gpa;

    // BAT BUOC PHAI CO CONTRUCTOR RONG, CONTRUCTOR FULL THAM SO
    //getter, setter, toString()
    // Boilder plate , lombok
    // them dependency lombok vao file pom.xml

    public Student() {
    }
    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}
