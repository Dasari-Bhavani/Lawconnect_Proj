package com.bhavani.LawyerManagementApp.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
@Cacheable
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String specialization;

    @Column
    private String city;

    @Column
    private Long phNo;

    @Column
    private String eMail;

    @Column
    private String pin;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinTable(name = "Lawyer_client",
            joinColumns = {@JoinColumn(name = "LawyerId")},
            inverseJoinColumns = {@JoinColumn(name = "clientId")}
    )
    private Set<Client> patList = null;

    public Set<Client> getPatList() {
        return patList;
    }

    public void setPatList(Set<Client> patList) {
        this.patList = patList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPhNo() {
        return phNo;
    }

    public void setPhNo(Long phNo) {
        this.phNo = phNo;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}
