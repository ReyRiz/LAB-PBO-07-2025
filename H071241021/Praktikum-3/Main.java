public class Main {
    public static void main(String[] args) {
        // Membuat objek BolaBasket
        bolaBasket bola1 = new bolaBasket("SpaldingX", 100, 30);
        bolaBasket bola2 = new bolaBasket("NikeAir", 30, 20);

        // Membuat objek Pemain
        Pemain p1 = new Pemain("LeBron James", 0, bola1);
        Pemain p2 = new Pemain("Kyrie Irving", 20, bola2);

        // Menampilkan info awal
        p1.info();
        p2.info();

        System.out.println("\nSTATUS");
        p1.status();
        p2.status();

        System.out.println("\nLEMMPARAN");
        p1.lempar(p2);

        System.out.println("\nSTATUS AKHIR");
        p1.status();
        p2.status();
    }
}
