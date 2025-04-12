public class No2 {
    public static void main(String[] args) {
        Produk produk = new Produk ("P001", "Produk A", 10, 25000);// jadi kalau 

        produk.displayInfo();
    
        if (produk.isAvailable()) {
            System.out.println("Produk tersedia di stok.");
        } else {
            System.out.println("Produk tidak tersedia di stok.");
        }
    }
}

class Produk{
    private String ID;
    private String nama;
    private int stok;
    private double harga;

    public Produk(String ID, String nama, int stok, double harga){
    this.ID = ID;
    this.nama = nama;
    this.stok = stok;
    this.harga = harga;
    }
    
    public String getID (){
        return ID;
    }
    public String getnama(){
        return nama;
    }
    public int getstok(){
        return stok;
    }
    public double getharga(){
        return  harga;
    }
    public void setstok(int stok){
        this.stok=stok;
    }
    public boolean isAvailable(){
        return stok >0;
    }
    public void displayInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
        System.out.println("Tersedia: " + (isAvailable() ? "Ya" : "Tidak"));
    }
}