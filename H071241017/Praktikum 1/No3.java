import java.util.Scanner;

public class No3 {
    public static void main(String[] Args) {
        Scanner d = new Scanner(System.in);
        System.out.print("dd-mm-yy: ");
        String input = d.nextLine();

        String[] parts = input.split("-");
        int hari = Integer.parseInt(parts[0]);
        int bulan = Integer.parseInt(parts[1]);
        int tahun = Integer.parseInt(parts[2]);

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        int tahunlengkap = (tahun < 100) ? 2000 + tahun : tahun;

        int[] hariDalamBulan = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Cek tahun kabisat
        if ((tahunlengkap % 4 == 0 && tahunlengkap % 100 != 0) || (tahunlengkap % 400 == 0)) {
            hariDalamBulan[1] = 29; 
        }

        // Validasi tanggal
        if (bulan < 1 || bulan > 12) {
            System.out.println("Bulan tidak valid!");
        } else if (hari < 1 || hari > hariDalamBulan[bulan - 1]) {
            System.out.println("Tanggal tidak valid!");
        } else {
            System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahunlengkap);
        }

        d.close();
    }
}
