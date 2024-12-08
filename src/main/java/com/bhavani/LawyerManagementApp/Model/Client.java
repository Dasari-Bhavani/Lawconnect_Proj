package com.bhavani.LawyerManagementApp.Model;


import jakarta.persistence.*;

@Entity
@Table
@Cacheable
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    @Column
    private String pname;

    @Column
    private Integer age;

    @Column
    private String city;

    @Column
    private Long phoneNo;

    @Column
    private String email;

    @Column
    private String pin;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
