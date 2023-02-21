package fr.epsi.Entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "FISH")
public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    @Column(name = "FishLivEnv")
    private FishLivEnv livingEnv;

    public Fish(Date birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    public Fish(String couleur, FishLivEnv livingEnv) {
        super(couleur);
        this.livingEnv = livingEnv;
    }

    public Fish() {

    }

    public Fish(String couleur) {
        super(couleur);
    }



    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
