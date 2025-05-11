public class Fighter extends Hero {
    public Fighter(String name) {
        this(name, 120, 15); // ← penggunaan this()
    }

    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(name + " memukul dengan kekuatan " + attackPower);
    }
}
