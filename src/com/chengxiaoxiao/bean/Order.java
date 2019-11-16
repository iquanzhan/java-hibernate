package com.chengxiaoxiao.bean;

import javax.persistence.*;

/**
 * @ClassName: Order
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-11-10
 */
@Entity
@Table(name="t_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Double money;
    private String receiverInfo; // 收货地址

    // 订单与客户关联
    @ManyToOne(targetEntity=Customer.class)
    @JoinColumn(name="c_customer_id") // 指定外键列
    private Customer c; // 描述订单属于某一个客户

    public Customer getC() {
        return c;
    }
    public void setC(Customer c) {
        this.c = c;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public String getReceiverInfo() {
        return receiverInfo;
    }
    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

}