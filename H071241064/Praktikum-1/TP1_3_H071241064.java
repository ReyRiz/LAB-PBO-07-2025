import java.util.Scanner;

public class TP1_3_H071241064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan tanggal (dd-mm-yy): ");
            String input = scanner.nextLine();
            
            String[] parts = input.split("-");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Format tanggal tidak valid.");
            }

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            year += (year < 50) ? 2000 : 1900; 

            String[] months = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };

            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Bulan tidak valid.");
            }

            System.out.println(day + " " + months[month - 1] + " " + year);

        } catch (NumberFormatException e) {
            System.out.println("Format tanggal salah! Gunakan angka dengan format dd-mm-yy.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

