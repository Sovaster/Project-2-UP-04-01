package com.example.Project2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String familia, Name, Otch, Grupa, Birthday;

    public Student(String Familia, String Name, String Otch, String Grupa, String Birthday)
    {
        this.familia = Familia;
        this.Name = Name;
        this.Otch = Otch;
        this.Grupa = Grupa;
        this.Birthday = Birthday;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOtch() {
        return Otch;
    }

    public void setOtch(String otch) {
        Otch = otch;
    }

    public String getGrupa() {
        return Grupa;
    }

    public void setGrupa(String grupa) {
        Grupa = grupa;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }
}
















