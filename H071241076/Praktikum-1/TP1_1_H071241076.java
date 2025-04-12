import java.util.Scanner;

public class TP1_1_H071241076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film : ");
        String input = scanner.nextLine();

        String[] kata = input.split(" ");
        String hasil = "";

        for (int i = 0; i < kata.length; i++) {
            if (kata[i].length() > 0) {
                char hurufAwal = Character.toUpperCase(kata[i].charAt(0));
                String sisaKata = kata[i].substring(1).toLowerCase();
                hasil += hurufAwal + sisaKata + " ";
            }
        }

        System.out.println(hasil.trim());
        scanner.close();
    }
}

