package com.example.practice.clazz;

/**
 * Pojo演示类
 * “Plain Old Java Object”“简单java对象”。POJO的内在含义是指那些没有从任何类继承、也没有实现任何接口，更没有被其它框架侵入的java对象。
 *
 * @author jerrylau
 */
public class Pojo {

    private String member1;

    private Integer member2;

    public Pojo(String member1, Integer member2) {
        this.member1 = member1;
        this.member2 = member2;
    }

    public Pojo(){

    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public void setMember2(Integer member2) {
        this.member2 = member2;
    }

    public Integer getMember2() {
        return member2;
    }

    public String getMember1() {
        return member1;
    }
}
