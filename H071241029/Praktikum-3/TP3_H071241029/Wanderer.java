package TP3_H071241029;

public class Wanderer {
    private String nama;
    private int health;

    public Wanderer() {
        this.nama = "Elysian Lacertus";
        this.health = 800;
    }

    public Wanderer(String nama, int health) {
        this.nama = nama;
        this.health = health;
    }

    public void diserang(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(nama + " menerima " + damage + " damage. Sisa health: " + health);
            System.out.println(nama + " telah kalah!");
        } else {
            System.out.println(nama + " menerima " + damage + " damage. Sisa health: " + health);
        }
    }

    public String getNama() {
        return nama;
    }

    public int getHealth() {
        return health;
    }
}