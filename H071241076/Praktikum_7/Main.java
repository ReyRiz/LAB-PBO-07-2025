import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.println("9. Hapus Log");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Jenis Item (1=Buku, 2=DVD): ");
                    int jenis = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Judul: ");
                    String title = sc.nextLine();

                    System.out.print("ID Item: ");
                    int id = sc.nextInt();

                    if (jenis == 1) {
                        sc.nextLine(); 
                        System.out.print("Penulis: ");
                        String author = sc.nextLine();
                        Book book = new Book(title, id, false, author);
                        System.out.println(library.addItem(book));
                        library.logger.logActivity("Item " + title + " ditambahkan ke perpustakaan");
                    } else if (jenis == 2) {
                        System.out.print("Durasi (menit): ");
                        int duration = sc.nextInt();
                        DVD dvd = new DVD(title, id, false, duration);
                        System.out.println(library.addItem(dvd));
                        library.logger.logActivity("Item " + title + " ditambahkan ke perpustakaan");
                    } else {
                        System.out.println("Jenis tidak dikenali.");
                    }
                }
                case 2 -> {
                    System.out.print("Nama Anggota: ");
                    String name = sc.nextLine();
                    System.out.print("ID Anggota: ");
                    int memberId = sc.nextInt();
                    Member member = new Member(name, memberId);
                    library.addMember(member);
                    System.out.println("Anggota berhasil ditambahkan.");
                    library.logger.logActivity("Anggota " + name + " ditambahkan");
                }
                case 3 -> {
                    try {
                        System.out.print("ID Anggota: ");
                        int memberId = sc.nextInt();
                        System.out.print("ID Item: ");
                        int itemId = sc.nextInt();
                        System.out.print("Lama pinjam (hari): ");
                        int days = sc.nextInt();

                        Member member = library.members.stream()
                                .filter(m -> m.memberId == memberId)
                                .findFirst()
                                .orElseThrow(() -> new Exception("Anggota tidak ditemukan."));
                        LibraryItem item = library.findItemById(itemId);
                        String result = member.borrow(item, days);
                        library.logger.logActivity(item.getDescription() + " dipinjam oleh " + member.name);
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("ID Anggota: ");
                        int memberId = sc.nextInt();
                        System.out.print("ID Item: ");
                        int itemId = sc.nextInt();
                        System.out.print("Terlambat (hari): ");
                        int daysLate = sc.nextInt();

                        Member member = library.members.stream()
                                .filter(m -> m.memberId == memberId)
                                .findFirst()
                                .orElseThrow(() -> new Exception("Anggota tidak ditemukan."));
                        LibraryItem item = library.findItemById(itemId);
                        String result = member.returnItem(item, daysLate);
                        library.logger.logActivity(item.getDescription() + " dikembalikan oleh " + member.name);
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                }
                case 5 -> System.out.println(library.getLibraryStatus());
                case 6 -> System.out.println(library.getAllLogs());
                case 7 -> {
                    System.out.print("ID Anggota: ");
                    int memberId = sc.nextInt();
                    library.members.stream()
                            .filter(m -> m.memberId == memberId)
                            .findFirst()
                            .ifPresentOrElse(
                                    Member::getBorrowedItems,
                                    () -> System.out.println("Anggota tidak ditemukan.")
                            );
                }
                case 8 -> {
                    System.out.println("Terima kasih!");
                    running = false;
                }
                case 9 -> {
                    library.logger.clearLogs();
                    System.out.println("Semua log aktivitas telah dihapus.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        // sc.close(); 
    }
}
