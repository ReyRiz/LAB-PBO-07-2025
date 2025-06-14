public class Book extends LibraryItem {
    String author;
    final double denda = 10000.0;

    public Book(String title, int itemId, boolean isBorrowed, String author) {
        super(title, itemId, isBorrowed);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed)
            throw new IllegalArgumentException("Item sudah dipinjam.");
        if (days > 14)
            throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal 14 hari.");
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * denda;
    }
}