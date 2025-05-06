public class wizard extends hero {
    public wizard(String name, int health, int attackPower){
        super(name, health, attackPower);
    }
    public void attack() {
        System.out.println(name + " melempar mantra dengan kekuatan " + attackPower);
    }
}
