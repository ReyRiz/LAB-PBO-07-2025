import java.util.Random;
import java.util.Scanner;
public class TP1_no2_H071241029  {
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        Random x = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = x.nextInt(9) + 1;
            }
        }
        Scanner y = new Scanner(System.in);
        System.out.print("Masukkan angka yang ingin dicari: ");
        try {
            int cari = y.nextInt();
            boolean dapat = false;
            for (int i = 0; i < 3 && !dapat; i++) {
                if (dapat == true) {
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        dapat = true;
                        break;
                    }
                }
            }
            if (!dapat) {
                System.out.println(cari + " tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Input harus bilangan bulat.");
        } finally {
            y.close();
        }
    }
}