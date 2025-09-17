package com.annguyen.supperapp;

import com.annguyen.supperapp.entity.Lectuter;
import com.annguyen.supperapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.annguyen.supperapp-PU");
    public static void main(String[] args) {
// insertStudent();// tao bang, chen data qua OOP, code first
// getAllStudent();// sellect * from Student theo style OOP, code first
  insertLectuter();
//    getAllLectuter();
//    searchLectuter();
        findByid();
       emf.close();

    }
    //INSERT / TAO MOI SV
    public static void insertLectuter() {
        EntityManager em = emf.createEntityManager();
        Lectuter vuong = new  Lectuter("Vuong Nguyen", 1980, 20_000_000);
        Lectuter linh = new  Lectuter("Linh Nguyen", 1985, 25_000_000);
        Lectuter anh = new  Lectuter("Anh Nguyen", 1990, 30_000_000);
        Lectuter binh = new  Lectuter("Binh Nguyen", 1995, 15_000_000);
        // goi sep Entity manager giup CRUD


        em.getTransaction().begin();
        em.persist(vuong);
        em.persist(linh);
        em.persist(anh);
        em.persist(binh);
        em.getTransaction().commit();
        em.close();

    }
    public static void getAllLectuter() {
        EntityManager em = emf.createEntityManager();
        List<Lectuter> result = em.createQuery("SELECT x FROM Lectuter x where x.salary = 20000000", Lectuter.class).getResultList();
        System.out.println("The list of lectuters: ");
       for (Lectuter x : result) {
           System.out.println(x);// goi tham ten em toString() cua sinh vien
        }

        //bieu thuc lambda- lamda expression, dinh dang cuc ki chat che voi stream API, co che xu li nhieu du lieu o trong ram
        // lamda expression la ham vo danh, ham an danh
        // dinh den khai niem lap trinh ham - functional programming
        // ham duoc xem la data va ham la tham so de truyen vao ham khac
//        System.out.println("The list of lectutersby lambda: ");
//        results.forEach( x -> {
//            //System.out.println(x);
//            System.out.printf("The list of 1 from 100");
//            for (int i = 1; i < 100; i++) {
//                System.out.println(i +" ");
//            }
//        });
        em.close();
    }

    public static void searchLectuter(){
        EntityManager em = emf.createEntityManager();
        List<Lectuter> result = em.createQuery("SELECT x FROM Lectuter x where x.salary = :pSalary", Lectuter.class).setParameter("pSalary", 20000000).getResultList();
//        String msg = "Hello";
//        String msgU = msg.toUpperCase();
//        String msgu = msg.toLowerCase();
        System.out.println("The list of lectuters: ");
        for (Lectuter x : result) {
            System.out.println(x);// goi tham ten em toString() cua sinh vien
        }
        em.close();
    }


    public static  void  insertStudent() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.annguyen.supperapp-PU");
        // GUI THONG SO CAU HINH Server. nha thau JPA: Hibernate, nha thau JDBC class lo de tao ket noi toi CSDL
        // cu the SQL Server, MySQL, Oracle, PostgreeSQL
        EntityManager em = emf.createEntityManager();
        // TAO RA 1 object dung de quan li cac entity class  duoc Map ngang sang table.Class student chiu su quan li cua em/Emtity manager
        // em/Entity manager se lo CRUD then 1 table nao do
        // qua may ham huyen thoai: persist(), merge(), remove(), find()
        // toan choi object , dang sau la TABLE bi anh huong - tu tao SQL ngam, va no cho minh thay cau sql nay luon khi minh cham cac ham o tren .persist(), .merge(), .remove(), .find()
        // cbi data Student - object nhen - OOP nhen
        Student an = new Student("SE1", "An Nguyen", 2000, 3.5);
        Student cuong = new Student("SE2", "Cuờng Nguyen", 2001, 3.6);
        // goi sep Entity manager giup CRUD
        em.getTransaction().begin();// bat buoc  phai co Transaction khi co su thay doi trong Db
        em.persist(an);// create table dien ra ngam
        em.persist(cuong);// goi la code first, code ra table
        //if (em.find(Student.class, "SE1") == null) {
           // em.persist(an);
        //}
        //if (em.find(Student.class, "SE2") == null) {
            //em.persist(cuong);
        //}
        //code ra data
        //insert into student values
        em.getTransaction().commit();// hoac ca 3 insert thanh cong, hoac chua ban nao dc insert
        // sellect   ko can , vi ko thay doi trang thai table
        em.close();// sa thai ong sep da xong
//        emf.close(); // ngat ket noi csdl vi da xong - khi app shutdown moi dong


    }


    // SELLECT * LAY HET DATA


    public static  void  getAllStudent(){
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.annguyen.supperapp-PU");

        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("FROM Student ", Student.class).getResultList();
        // query nay giong cau lenh sql: select * from Student, nhung theo style OOP , CO OBJECT VA DAU CHAM, GOI LA JPQL,HQL
        System.out.println("The list of students (" + result.size() + "records): ");
        for (Student x : result) {
            System.out.println(x);// goi tham ten em toString() cua sinh vien

        }
        // dung bieu thuc lambda in ra cung dc
        em.close();
        //emf.close();
    }
//    //EntityManager là ông sếp quản lí các Entity ~ chính là các class có @Entity và
//    quản lí các object tạo từ class Entity: sếp có thể thêm persit(); xoá remove();
//    cập nhật merge(); tìm theo PK find(): lí do có hàm tìm theo key, vì ta luôn có nhu
//    cầu thao tác trên 1 dòng/row/record cụ thể trong table
//
//SWP admin, có màn hình quản lí user, phân loại, show table có nhiều dòng, phân
//            trang, filter, cuối dòng có cột Actions: Update | Delete -> xử lí đúng 1 dòng đang
//    select -> theo PK
//
//ngoài ra có hàm createQuery() tìm linh hoạt theo điều kiện nào đó
//
//    //HỌC THÊM VỀ JPQL: JAVA PERSISTENCE QUERY LANGUAGE
    public static void findByid(){
        EntityManager em = emf.createEntityManager();
        // tim theo key chi tra ve 1 dong
        Lectuter x = em.find(Lectuter.class, 1);
        Student y = em.find(Student.class, "SE2");
        System.out.println("Lectuter found: " + x);
        System.out.println("Student found: " + y);


    }
    // khi lam cac hanh dong,xoa , sua , them anh huong va thay doi hien trang DB
    // ta phai nhet no vao ransaction de theo doi: hoac tat ca, hoac tat ca, hoac ko gi ca
    // nguyen li do all or nothing: Acid
    public static void RemoveByid(){
        EntityManager em = emf.createEntityManager();
        // tim theo key chi tra ve 1 dong
        Lectuter x = em.find(Lectuter.class, 1);
        Student y = em.find(Student.class, "SE2");
        System.out.println("Lectuter found: " + x);
        System.out.println("Student found: " + y);


    }
}
