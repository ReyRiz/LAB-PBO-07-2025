public class no2 {
    public static void main(String[] args) {
    Produk laptop = new Produk("P001", "Laptop Asus", 5, 140000);
        
        laptop.displayProduct();
        laptop.setStock(0);

        System.out.println("\nAfter stock update:");
        laptop.displayProduct();
    }
}
