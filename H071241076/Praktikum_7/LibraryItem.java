public abstract class LibraryItem {
    String title;
    int itemId;
    boolean isBorrowed;

    public LibraryItem(String title, int itemId, boolean isBorrowed) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = isBorrowed;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        isBorrowed = false;
        return title + " dikembalikan";
    }
}
