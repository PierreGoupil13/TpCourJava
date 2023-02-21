package fr.epsi.Entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private Date birth;
    private String couleur;
    @ManyToOne(cascade = CascadeType.ALL)
    private PetStore petStore;

    public Animal() {
    }

    public Animal(String couleur) {
        this.couleur = couleur;
    }

    public Animal(Date birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public Animal(long id, Date birth, String couleur) {
        this.id = id;
        this.birth = birth;
        this.couleur = couleur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {

        if (this.petStore != null) {
            this.petStore.getAnimals().remove(this);
        }

        this.petStore = petStore;

        if (this.petStore != null) {
            this.petStore.getAnimals().add(this);
        }
    }
}
