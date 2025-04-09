import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan judul film: ");
        String[] judul = input.nextLine().trim().split("\\s+");

        for (int i = 0; i < judul.length; i++) {
            if (judul[i].length() > 0) {
                judul[i] = Character.toUpperCase(judul[i].charAt(0)) + judul[i].substring(1).toLowerCase();
            }
        }

        System.out.println("Hasil Format Judul: " + String.join(" ", judul)); //join agar menggabungkan berdasarkan spasi

        input.close();
    }
}
