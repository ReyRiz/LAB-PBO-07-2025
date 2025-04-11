public class TP2_no2_H071241029 {
    private String productId;
    private String name;
    private int stock;
    private double price;

    public String getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public int getStock() {
        return stock;
    }
    public double getPrice() {
        return price;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return stock > 0;
    }
    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Stock: " + stock);
        System.out.println("Price: Rp" + price);
        System.out.println("Availability: " + (isAvailable() ? "In Stock" : "Out of Stock"));
    }
    public static void main(String[] args) {
        TP2_no2_H071241029 p1 = new TP2_no2_H071241029();
        p1.setProductId("A001");
        p1.setName("AC");
        p1.setStock(5);
        p1.setPrice(1.999);

        TP2_no2_H071241029 p2 = new TP2_no2_H071241029();
        p2.setProductId("A002");
        p2.name = "bbbb";
        p2.setName("Kipas");
        p2.setStock(0);
        p2.setPrice(599.99);
        p1.displayProductInfo();
        System.out.println();
        p2.displayProductInfo();
    }
}