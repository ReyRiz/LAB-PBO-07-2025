import java.util.*;

public class Member {
    String name;
    int memberId;
    List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item tidak tersedia.");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak sedang dipinjam.";
        }
        double fine = item.calculateFine(daysLate);
        borrowedItems.remove(item);
        item.returnItem();
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.2f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
            System.out.printf("%-5s| %-25s| %-10s| %-30s\n", "ID", "Judul", "Jenis", "Info");
            System.out.println("--------------------------------------------------------------------------");

            for (LibraryItem item : borrowedItems) {
                String jenis;
                String info;

                if (item instanceof Book b) {
                    jenis = "Buku";
                    info = "Penulis: " + b.author;
                } else if (item instanceof DVD d) {
                    jenis = "DVD";
                    info = "Durasi: " + d.duration + " menit";
                } else {
                    jenis = "Lainnya";
                    info = "-";
                }

                System.out.printf("%-5d| %-25s| %-10s| %-30s\n", item.itemId, item.title, jenis, info);
            }
        }
    }

}
