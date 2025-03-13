import java.util.Scanner;
public class TP1_no5_H071241029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        if (valid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
            System.out.println("Pastikan format password sesuai");
        }
        scanner.close();
    }
    public static boolean valid(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean besar = false;
        boolean kecil = false;
        boolean angka = false;
        for (int i = 0; i < password.length(); i++) {
            char n = password.charAt(i);
            if (Character.isUpperCase(n)) {
                besar = true;
            } else if (Character.isLowerCase(n)) {
                kecil = true;
            } else if (Character.isDigit(n)) {
                angka = true;
            }
        }
        return besar && kecil && angka;
    }
}