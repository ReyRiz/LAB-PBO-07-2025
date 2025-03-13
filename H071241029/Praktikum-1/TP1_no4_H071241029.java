import java.util.InputMismatchException;
import java.util.Scanner;
public class TP1_no4_H071241029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Input : ");
            int n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Input tidak valid. Masukkan bilangan non-negatif.");
            }else {
                long hasil = faktorial(n);
                System.out.println("Output : " + hasil);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan bilangan bulat.");
        } finally {
            scanner.close();
        }
    }
    public static long faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;  // 0! && 1! = 1
        } else {
            return n * faktorial(n - 1);
        }
    }
}