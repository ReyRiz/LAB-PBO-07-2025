class Pemain {
    private String nama;
    private int stamina;
    private bolaBasket bolaBasket;

    // Constructor default
    public Pemain() {
        this.nama = "Jordan";
        this.stamina = 100;
        this.bolaBasket = new bolaBasket();
    }

    // Constructor dengan parameter
    public Pemain(String nama, int stamina, bolaBasket bolaBasket) {
        this.nama = nama;
        this.stamina = stamina;
        this.bolaBasket = bolaBasket;
    }

    // Method info
    public void info() {
        System.out.println("\nNama Pemain: " + nama);
        System.out.println("Stamina: " + stamina);
        bolaBasket.infoBolaBasket();
    }

    // Method status
    public void status() {
        if (stamina <= 0) {
            System.out.println(nama + " sudah kelelahan total. Perlu istirahat!");
        } else if (bolaBasket.getKetahanan() <= 0) {
            System.out.println(nama + " bolanya sudah rusak. Tidak bisa bermain!");
        } else if (stamina < 30) {
            System.out.println(nama + " mulai kelelahan. Sebaiknya ganti pemain.");
        } else {
            System.out.println(nama + " dalam kondisi prima dan siap bertanding!");
        }
    }

    // Method interaksi antar objek: melempar bola
    public void lempar(Pemain target) {
        int damage = this.bolaBasket.getPantulan();
        if (this.bolaBasket.getKetahanan() <= 0) {
            System.out.println(nama + " gagal melempar. Bola sudah rusak!");
            return;
        }

        this.bolaBasket.kurangiKetahanan(10);
        target.stamina -= damage;

        System.out.println(nama + " melempar bola ke " + target.nama + " menggunakan Bola " + bolaBasket.getMerk() + "!");
        System.out.println("Stamina " + target.nama + " sekarang: " + target.stamina);
        System.out.println("Ketahanan bola " + nama + ": " + this.bolaBasket.getKetahanan());
    }
}
