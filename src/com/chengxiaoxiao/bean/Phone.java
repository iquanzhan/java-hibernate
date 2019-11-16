package com.chengxiaoxiao.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @ClassName: Phone
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-11-10
 */
@Entity
@Table(name = "phone", schema = "test")
public class Phone {
    private String tel;
    private String pname;
    private Double price;
    private Student student;

    public Phone() {
    }

    public Phone(String tel, String pname, Double price) {
        this.tel = tel;
        this.pname = pname;
        this.price = price;
    }

    public Phone(String tel, String pname, Double price, Student student) {
        this.tel = tel;
        this.pname = pname;
        this.price = price;
        this.student = student;
    }

    @Id
    @GeneratedValue(generator = "tel")
    @GenericGenerator(name = "tel", strategy = "assigned") //自己指派主键生成策略
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "pname")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToOne(cascade = CascadeType.ALL) //全部级联CRUD操作
    @JoinColumn(name = "sid", unique = true) //name指的是主表的外键,unique表示是否是唯一的
    public Student getStudents() {
        return student;
    }

    public void setStudents(Student students) {
        this.student = students;
    }
}
