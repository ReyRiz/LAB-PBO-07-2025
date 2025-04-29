class Hero {
    String name;
    int health;
    int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Archer extends Hero {
    public Archer() {
        super("Pemanaah", 80, 15); 
    }
}

class Wizard extends Hero {
    public Wizard() {
        super("Penyihir", 70, 20);
    }
}

class Fighter extends Hero {
    String pedang;
    public Fighter(String name, int health, int attackpower, String pedang) {
        super(name, health, attackpower);
        this.pedang = pedang;
    }

    public Fighter() {
        this("Aaa", 80, 12, "asda");
        System.out.println(name + " menggunakan " + pedang + " sebagai senjata"); 
    }
}
