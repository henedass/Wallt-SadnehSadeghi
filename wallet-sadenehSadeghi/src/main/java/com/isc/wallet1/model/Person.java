package com.isc.wallet1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Digits(integer = 10, fraction = 0)
    private long id;

    @Column(nullable = false)
    @Pattern(regexp = "^09\\d{9}", message = "Phone number must start with 09 and have 11 digits")
    private String phoneNum;
    @Column(nullable = false)
    private String fName; // نام
    @Column(nullable = false)
    private String lName; // نام خانوادگی
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthday; // تاریخ تولد
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String gender; // جنسیت//     should be male/Male or female/Female
    @Column(nullable = false)
    private boolean militStat; //وضعیت سربازی آقایان

    @Column(nullable = false)
    @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    private String email;

    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isMilitStat() {
        return militStat;
    }

    public void setMilitStat(boolean militStat) {
        this.militStat = militStat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}

