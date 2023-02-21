package fr.epsi.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String managerName;
    @ManyToMany(mappedBy = "petStores", cascade = CascadeType.ALL)
    private Set<Product> products;
    {
        products = new HashSet<>();
    }
    @OneToMany(mappedBy = "petStore",cascade = CascadeType.ALL)
    private Set<Animal> animals;
    {
        animals = new HashSet<>();
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADS_ID", referencedColumnName = "id")
    private Address address;

    public PetStore() {
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addAddress(Address ads){
        ads.setPetStore(this);
        this.address = ads;
    }

    public void addAnimal(Animal animal){
        animal.setPetStore(this);
    }
    public void addCat(Cat cat){
        cat.setPetStore(this);
    }

    public void addProduct(Product product){
        this.products.add(product);
        product.getPetStores().add(this);
    }

}
