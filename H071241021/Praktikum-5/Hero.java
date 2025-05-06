public class Hero{
    String name;
    int health;
    int damage;

    public Hero(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public void attack(){
        System.out.println(name + " Menyerang dengan kekuatan " + damage);
    }

}
