package fr.epsi.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String label;
    // Pour le Prod type faut ajouter un Enum a voir ça
    @Enumerated(EnumType.STRING)
    private ProdType prodType;
    private double price;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_STORE", referencedColumnName = "ID")
    )
    private Set<PetStore> petStores;
    {
        petStores = new HashSet<>();
    }

    public Product() {
    }

    public Product(String code, String label, double price) {
        this.code = code;
        this.label = label;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getProdType() {
        return prodType;
    }

    public void setProdType(ProdType prodType) {
        this.prodType = prodType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    public void addPetstore(PetStore petStore){
        this.petStores.add(petStore);
        petStore.getProducts().add(this);
    }
}
