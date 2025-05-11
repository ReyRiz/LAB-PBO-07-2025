public class Wizard extends Hero{
    public Wizard(String name) {
        super(name, 80, 25);
    }

    @Override
    public void attack() {
        System.out.println(name + " mengeluarkan sihir dengan kekuatan " + attackPower);
    }
}
