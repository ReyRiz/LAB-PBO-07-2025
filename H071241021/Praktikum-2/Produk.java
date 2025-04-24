// class for no 2
class Produk{
    String id;
    String name;
    int stock;
    double price;

    Produk(String id, String name, int stock, double price){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getStock(){
        return id;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public boolean isAvailable(){
        return stock > 0;
    }

    public void displayProduct(){
        System.out.println("Product ID" + id);
        System.out.println("Name" + name);
        System.out.println("Stock:" + stock );
        System.out.println("Price: Rp." + price);
        System.out.println("Status: " +(isAvailable() ? "Available" : "Out of Stock"));
    }
    
} 
