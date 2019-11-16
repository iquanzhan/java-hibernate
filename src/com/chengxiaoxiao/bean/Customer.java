package com.chengxiaoxiao.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Customer
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-11-10
 */
@Entity
@Table(name="t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id; // 主键
    private String name; // 姓名

    // 描述客户可以有多个订单
    /*
     * targetEntity="..."：相当于<one-to-many class="...">
     * mappedBy="..."：相当于inverse=true，即放弃关联关系的维护，不然会生成一个中间表
     */
    @OneToMany(targetEntity=Order.class,mappedBy="c")
    private Set<Order> orders = new HashSet<Order>();

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}