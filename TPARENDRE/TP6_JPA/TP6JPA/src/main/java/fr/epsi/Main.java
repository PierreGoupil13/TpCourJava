package fr.epsi;

import fr.epsi.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-tp6");

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Pet Stores
        PetStore maxiZoo = new PetStore("Maxi Zoo", "Pierre");
        PetStore miniZoo = new PetStore("Mini Zoo", "Titouan");
        PetStore moyenZoo = new PetStore("Moyen Zoo", "Etienne");

        Address ads1 = new Address("6", "rue du calvaire", "44610", "Indre");
        Address ads2 = new Address("7", "rue du calvaire", "44610", "Indre");
        Address ads3 = new Address("8", "rue du calvaire", "44610", "Indre");

        Product productM1 = new Product("123", "Wiskas",12);
        Product productM2 = new Product("1234", "Grattoire",56);
        Product productM3 = new Product("1235", "Arbre a chat",120);

        // Animaux
        Animal fishUn = new Fish(new Date(),"Rouge",FishLivEnv.FRESH_WATER);
        Animal fishDeux = new Fish(new Date(),"Noir",FishLivEnv.FRESH_WATER);
        Animal fishTrois = new Fish(new Date(),"Bleu",FishLivEnv.SEA_WATER);
        Animal chatUn = new Cat(new Date(),"Rouge","34");
        Animal chatDeux = new Cat(new Date(),"Noir","35");
        Animal chatTrois = new Cat(new Date(),"Bleu","36");

        // Ajout des enregistrements
        maxiZoo.addAddress(ads1);
        maxiZoo.addProduct(productM1);
        maxiZoo.addProduct(productM2);
        maxiZoo.addProduct(productM3);
        maxiZoo.addAnimal(fishUn);
        maxiZoo.addAnimal(fishDeux);
        maxiZoo.addAnimal(fishTrois);
        maxiZoo.addAnimal(chatUn);
        maxiZoo.addAnimal(chatDeux);
        maxiZoo.addAnimal(chatTrois);

        miniZoo.addAddress(ads2);
        moyenZoo.addAddress(ads3);

        em.persist(maxiZoo);
        em.persist(miniZoo);
        em.persist(moyenZoo);

        transaction.commit();
    }
}