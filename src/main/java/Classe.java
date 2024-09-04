package main.java;

public enum Classe  {
    ASSASSIN(50,4,1,"L'assassin"),
    BARBARE(150,2,2,"Le barbare"),
    MAGE(100,2,3,"Le grand mage");

    public int pv;
    public int atk;
    public int def;
    public String nom;
    public double critRate;
    public double critDamage;

    Classe(int pv, int atk, int def, String nom){
        this.pv = pv;
        this.atk = atk;
        this.def = def;
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
    
    public String getNom() {
        return nom;
    }

    public double getCritRate() {
        return this.critRate;
    }

    public double getCritDamage() {
        return this.critDamage;
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

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }
}
