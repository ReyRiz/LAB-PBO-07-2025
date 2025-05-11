import java.util.Scanner;

public class Mainhero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("> ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Masukkan nama karakter: ");
        String name = sc.nextLine();

        switch (choice) {
            case 1:
                hero = new Archer(name);
                break;
            case 2:
                hero = new Wizard(name);
                break;
            case 3:
                hero = new Fighter(name);
                break;
            default:
                System.out.println("Pilihan tidak tersedia.");
                System.exit(0);
        }

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("> ");
            int action = sc.nextInt();

            if (action == 1) {
                hero.attack();
            } else if (action == 2) {
                System.out.println("Kamu keluar dari permainan.");
                break;
            } else {
                System.out.println("Menu tidak tersedia.");
            }
        }

        sc.close();
    }
}
