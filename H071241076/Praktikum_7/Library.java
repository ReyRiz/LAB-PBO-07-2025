import java.util.*;

public class Library {
    List<LibraryItem> items = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
            .filter(item -> item.itemId == itemId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s| %-25s| %-10s\n", "ID", "Judul", "Status"));
        sb.append("----------------------------------------------\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("%-5d| %-25s| %-10s\n", item.itemId, item.title, status));
        }

        return sb.toString();
    }


    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) {
        members.add(member);
    }
}
