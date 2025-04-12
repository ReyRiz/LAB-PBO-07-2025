import java.util.Scanner;

public class TP1_3_H071241076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan tanggal (dd-mm-yy): ");
            String input = scanner.nextLine(); 

            String[] bagian = input.split("-");

            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            int tahun = Integer.parseInt(bagian[2]);

            
            if (tahun > 25) {
                tahun += 1900;
            } else {
                tahun += 2000;
            }

            
            String[] namaBulan = {
                "Januari", "Februari", "Maret", "April",
                "Mei", "Juni", "Juli", "Agustus",
                "September", "Oktober", "November", "Desember"
            };

            
            if (hari < 1 || hari > 31 || bulan < 1 || bulan > 12) {
                System.out.println("Tanggal atau bulan tidak valid!");
            } else {
                
                System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
            }

        } catch (Exception e) {
            System.out.println("Format input salah! Gunakan format dd-mm-yy.");
        }

        scanner.close();
    }
}
