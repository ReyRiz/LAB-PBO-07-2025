import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Hero hero1 = new Archer("Pemanah", 100, 20);
        Hero hero2 = new Wizard("Penyihir", 120, 25);
        Hero hero3 = new Fighter("Fighter", 90, 15);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("********");
            System.out.println("Pilih Karakter");
            System.out.println("1. Archer");
            System.out.println("2. Wizard");
            System.out.println("3. Fighter");
            
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();

            if (pilihan < 1 || pilihan > 3) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue; // Kembali ke awal loop untuk meminta input lagi
            }

            System.out.println("Menu: ");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            if (menu == 1) {
                switch (pilihan) {
                    case 1:
                        hero1.attack();
                        break;
                    case 2:
                        hero2.attack();
                        break;
                    case 3:
                        hero3.attack();
                        break;
                }
            } else if (menu == 2) {
                System.out.println("Keluar dari program.");
                break; // Keluar dari loop dan program
            } else {
                System.out.println("Menu tidak valid. Silakan coba lagi.");
            }
        }
    }
}