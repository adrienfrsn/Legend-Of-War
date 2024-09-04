package main.java;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Entity {
    private int level;
    private int xp;
    private int xpmax;
    private List<Item> inventory = new ArrayList<Item>();
    private Classe categorie = Classe.ASSASSIN;
    private ArrayList<Competence> listeCompetences;

    public Joueur(){
        new Joueur(null,1,1,10,new ArrayList<>());
    };

    public Joueur(String nom, int level, int xp, int xpmax, List<Item> inventory) {
        this.nom = nom;
        this.level = level;
        this.xp = xp;
        this.xpmax = xpmax;
        this.inventory = inventory;
    }

    public void addXp(int valeur) {
        this.xp = this.xp + valeur;
        if (this.xp >= this.xpmax) {
            if (this.level == 30) {
                this.xp = this.xpmax - 1;
            } else {
                lvlUp();
            }

        }
    }

    private void lvlUp() {
        this.xp = 0;
        this.level++;
        this.xpmax *= 1.1;
        this.pv += 20;
        this.def += 5;
        this.atk += 10;
    }

    public void resetBuff() {
        this.atk = this.categorie.atk + (10 * this.level);
        this.pv = this.categorie.pv + (20 * this.level);
        this.def = this.categorie.def + (5 * this.level);
    }

    public boolean addInventory(Item object) {
        return inventory.add(object);
    }

    public boolean removeInventory(Item object) {
        return inventory.remove(object);
    }

    public int getLevel() {
        return this.level;
    }

    public int getXp() {
        return this.xp;
    }

    public int getXpmax() {
        return this.xpmax;
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public int getPv() {
        return this.pv;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public String getNom() {
        return this.getCategorie().getNom();
    }

    public Classe getCategorie() {
        return categorie;
    }

    public void setCategorie(Classe categorie) {
        this.categorie = categorie;

        switch (categorie) {
            case ASSASSIN:
                this.pv = 100;
                this.atk = 40;
                this.def = 30;
                this.listeCompetences = new ArrayList<Competence>();
                this.listeCompetences.add(Competence.COUVERTURE_DE_SANG);
                this.listeCompetences.add(Competence.VAMPIRISME);
                this.listeCompetences.add(Competence.EXECUTION);
                break;
            case BARBARE:
                this.pv = 200;
                this.atk = 70;
                this.def = 60;
                this.listeCompetences = new ArrayList<Competence>();
                this.listeCompetences.add(Competence.INTIMIDATION);
                this.listeCompetences.add(Competence.SOINS_MINEURS);
                this.listeCompetences.add(Competence.TOUT_OU_RIEN);
                break;
            case MAGE:
                this.pv = 150;
                this.atk = 110;
                this.def = 20;
                this.listeCompetences = new ArrayList<Competence>();
                this.listeCompetences.add(Competence.ARMURE_MAGIQUE);
                this.listeCompetences.add(Competence.SOINS_MAJEURS);
                this.listeCompetences.add(Competence.PLUIE_SANGUINE);

                break;

            default:
                break;
        }

    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
