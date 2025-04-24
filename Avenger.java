public class Avenger {
    private String nama;
    private int health;
    private Senjata senjata;

    public Avenger(String nama, int health, Senjata senjata) {
        this.nama = nama;
        this.health = health;
        this.senjata = senjata;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Senjata getSenjata() {
        return senjata;
    }

    public void setSenjata(Senjata senjata) {
        this.senjata = senjata;
    }

    public void serang(Avenger target) {
        System.out.println(this.nama + " menyerang " + target.getNama() + " dengan " + this.senjata.getNama());
        target.health -= this.senjata.getKekuatan();
        if (target.health < 0) target.health = 0;
        System.out.println("HP " + target.getNama() + " setelah diserang: " + target.getHealth());
    }

    public void serangBalik(Avenger attacker) {
        System.out.println(this.nama + " menyerang balik " + attacker.getNama() + " dengan " + this.senjata.getNama());
        attacker.health -= this.senjata.getKekuatan();
        if (attacker.health < 0) attacker.health = 0;
        System.out.println("HP " + attacker.getNama() + " setelah diserang balik: " + attacker.getHealth());
    }

    public void pulihkanDiri() {
        System.out.println(this.nama + " memulihkan diri!");
        this.health += 20;
        if (this.health > 100) this.health = 100; 
        System.out.println("HP " + this.nama + " setelah pemulihan: " + this.health);
    }

    public void status() {
        System.out.println(nama + " | HP: " + health + " | Senjata: " + senjata.getNama());
    }
}


