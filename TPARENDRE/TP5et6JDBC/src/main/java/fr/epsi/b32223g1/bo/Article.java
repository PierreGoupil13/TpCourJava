package fr.epsi.b32223g1.bo;

public class Article {
    private int id;
    private String ref;
    private String designation;
    private float prix;

    //A voir comment gerer le lien entre un fournisseur et un article
    // En BDD on a pas de fournisseur
    private Fournisseur fournisseur;

    // Est-ce qu'il faut faire 36 constructeurs ?
    public Article(int id, String ref, String designation, float prix, Fournisseur fournisseur) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    public Article(String designation, float prix, Fournisseur fournisseur, String ref) {
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
        this.ref = ref;
    }




    public Fournisseur get_fournisseur() {
        return this.fournisseur;
    }
    public void setId_four(int id_four) {
        this.fournisseur = fournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String deisgnation) {
        this.designation = deisgnation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getName() {
        return this.designation;
    }

    public float getPrice() {
        return this.prix;
    }


    @Override
    public String toString() {
        return "Fournisseur{" +
                "id= " + id + ", " +
                "designation= " + designation +
                "ref= " + ref +
                "prix= " + prix +
                "fournisseur= " + fournisseur +
                '\'' + '}';
    }

}
