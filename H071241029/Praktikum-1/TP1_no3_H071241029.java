import java.util.Scanner;
public class TP1_no3_H071241029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();
        try {
            String[] format = input.split("-");
            if (format.length != 3) {
                throw new Exception("Format tanggal tidak valid!");
            }
            int hari = Integer.parseInt(format[0]);   // menghilangkan nol di depan
            int bulan = Integer.parseInt(format[1]);
            int tahun = Integer.parseInt(format[2]);
            // Validasi bulan dan hari
            if (bulan < 1 || bulan > 12) {
                throw new Exception("Bulan tidak valid");
            }
            if (hari < 1 || hari > 31) {
                throw new Exception("Hari tidak valid");
            }
            //jika tahun < 50 maka dianggap 2000+, jika tidak 1900+
            if (tahun < 50) {
                tahun = 2000 + tahun;
            } else {
                tahun = 1900 + tahun;
            }
            String namaBulan;
            switch (bulan) {
                case 1: namaBulan = "Januari"; break;
                case 2: namaBulan = "Februari"; break;
                case 3: namaBulan = "Maret"; break;
                case 4: namaBulan = "April"; break;
                case 5: namaBulan = "Mei"; break;
                case 6: namaBulan = "Juni"; break;
                case 7: namaBulan = "Juli"; break;
                case 8: namaBulan = "Agustus"; break;
                case 9: namaBulan = "September"; break;
                case 10: namaBulan = "Oktober"; break;
                case 11: namaBulan = "November"; break;
                case 12: namaBulan = "Desember"; break;
                default: namaBulan = "Invalid"; break;
            }
            System.out.println(hari + " " + namaBulan + " " + tahun);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}