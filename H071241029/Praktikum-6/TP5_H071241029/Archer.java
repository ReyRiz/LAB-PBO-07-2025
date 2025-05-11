public class Archer extends Hero {
    public Archer(String name) {
        super(name, 100, 20);
    }

    @Override
    public void attack() {
        System.out.println(name + " menembakkan panah dengan kekuatan " + attackPower);
    }
}
