package com.springbootDemo.pojo;

import javax.persistence.*;

@Table(name = "lj_user")
public class LjUser {
    /**
     * 用户编号
     */
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 获取用户编号
     *
     * @return id - 用户编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户编号
     *
     * @param id 用户编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取家庭地址
     *
     * @return address - 家庭地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置家庭地址
     *
     * @param address 家庭地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
}