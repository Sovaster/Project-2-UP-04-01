package com.example.Project2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prepod
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String familia, Name, Otch, Predmeti, Grafic;

    public Prepod(String Familia, String Name, String Otch, String Predmeti, String Grafic)
    {
        this.familia = Familia;
        this.Name = Name;
        this.Otch = Otch;
        this.Predmeti = Predmeti;
        this.Grafic = Grafic;
    }

    public Prepod() {

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

    public String getPredmeti() {
        return Predmeti;
    }

    public void setPredmeti(String predmeti) {
        Predmeti = predmeti;
    }

    public String getGrafic() {
        return Grafic;
    }

    public void setGrafic(String grafic) {
        Grafic = grafic;
    }
}
















