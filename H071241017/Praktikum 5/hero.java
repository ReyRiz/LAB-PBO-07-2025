public class hero {
    String name;
    int health;
    int attackPower;

    public hero(String name, int health, int attackPower){
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }

}

