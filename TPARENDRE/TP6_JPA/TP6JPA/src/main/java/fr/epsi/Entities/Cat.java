package fr.epsi.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CAT")
public class Cat extends Animal{
    private String chipId;

    public Cat(Date birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    public Cat(String couleur, String chipId) {
        super(couleur);
        this.chipId = chipId;
    }

    public Cat() {

    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
