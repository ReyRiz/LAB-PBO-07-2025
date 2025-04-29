import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                hero = new Archer();
                break;
            case 2:
                hero = new Wizard();
                break;
            case 3:
                hero = new Fighter("Fighter", 70, 90, "Excalibur");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                System.exit(0);
        }

        int menu;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            menu = scanner.nextInt();

            if (menu == 1) {
                hero.attack();
            } else if (menu == 2) {
                System.out.println("Game selesai!");
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } while (menu != 2);

        scanner.close();
    }
}