import java.util.Scanner;

public class TP1_4_H071241076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan bilangan: ");
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Bilangan tidak boleh negatif.");
            } else {
                int hasil = faktorial(n);
                System.out.println("Output : " + hasil);
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat!");
        }

        scanner.close();
    }

    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }
}
