package com.example.Project2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 50, message = "От 1 до 50 символов")
    private  String familia, name;

    @Size(min = 0, max = 50, message = "До 50 символов")
    private  String otch;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 50, message = "От 1 до 50 символов")
    private  String grupa;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 10, max = 10, message = "Должно быть 10 символов")
    private  String birthday;

    public Student(String Familia, String Name, String Otch, String Grupa, String Birthday)
    {
        this.familia = Familia;
        this.name = Name;
        this.otch = Otch;
        this.grupa = Grupa;
        this.birthday = Birthday;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
















