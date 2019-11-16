package com.chengxiaoxiao.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @ClassName: Student
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-11-10
 */
@Entity //表明这是一个数据库实体
@Table(name = "Students")
public class Student {
    //统一代码规范将注解设置在get方法上面而不是设置在属性上面
    private Integer sid;
    private String sname;
    private Integer age;

    private Phone phone;

    //无参构造
    public Student() {
    }

    //全参构造
    public Student(Integer sid, String sname, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
    }

    @Id //表示这是一个主键列
    //定义主键的生成策略,assigned表示是自己指派的
    @GeneratedValue(generator = "sid")
    @GenericGenerator(name = "sid", strategy = "assigned")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * Basic,定义属性的存取获取策略
     * Basic(FetchType.EAGER):默认，表示即时存取
     * Basic(FetchType.LAZY)：延迟加载
     */
    @Basic //这里设置默认就可以了
    @Column(length = 13, name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="tel",unique = true)  //name指的是主表的外键，数据库中的外键,unique表示是否是唯一的
    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
