public class fighter extends hero {
    public fighter(String name, int health){
        this(name, health, 20);
    }
    public fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
}