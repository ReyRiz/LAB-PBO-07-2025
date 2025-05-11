import java.util.Scanner;

class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

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
        super("Archer", 80, 15);
    }
}

class Wizard extends Hero {
    public Wizard() {
        super("Wizard", 70, 20);
    }
}

class Fighter extends Hero {
    public Fighter() {
        this("Fighter", 100, 18); // this() chaining ke konstruktor di bawah
    }

    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero selectedHero = null;

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                selectedHero = new Archer();
                break;
            case 2:
                selectedHero = new Wizard();
                break;
            case 3:
                selectedHero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        int aksi;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            aksi = scanner.nextInt();

            switch (aksi) {
                case 1:
                    selectedHero.attack();
                    break;
                case 2:
                    System.out.println("Game selesai!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (aksi != 2);

        scanner.close();
    }
}
