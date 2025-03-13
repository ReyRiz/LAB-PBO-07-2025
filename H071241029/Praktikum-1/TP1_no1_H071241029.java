import java.util.Scanner;
public class TP1_no1_H071241029 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Judul Film:");
        String film = input.nextLine();
        System.out.println(kapital(film));
        input.close();
    }
    public static String kapital(String film) {
        String[] kalimat = film.split(" ");
        StringBuilder hasil = new StringBuilder();
        for (String kata : kalimat) {
            if (!kata.isEmpty()) {
                hasil.append(Character.toUpperCase(kata.charAt(0)));
                if (kata.length() > 1) {
                    hasil.append(kata.substring(1).toLowerCase());
                }
                hasil.append(" ");
            }
        }
        return hasil.toString().trim();
    }
}