package com.ruanxinxin.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private  Integer id;
    private  String lastName;
    private  String email;
    private  String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee [id="+id+", lastName="+lastName+", email="+email+", gender="+gender+"]";
    }

    /**
     *
     * @param id
     * @param lastName
     * @param email
     * @param gender
     */
    public Employee(Integer id, String lastName,String email,String gender){
        this.id=id;
        this.lastName=lastName;
        this.email=email;
        this.gender=gender;
    }
    public Employee(){}
}
