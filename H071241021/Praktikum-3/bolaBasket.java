class bolaBasket {
    private String merk;
    private int ketahanan;
    private int pantulan;

    // Constructor default
    public bolaBasket() {
        this.merk = "Molten";
        this.ketahanan = 100;
        this.pantulan = 25;
    }

    // Constructor dengan parameter
    public bolaBasket(String merk, int ketahanan, int pantulan) {
        this.merk = merk;
        this.ketahanan = ketahanan;
        this.pantulan = pantulan;
    }

    public int getKetahanan() {
        return ketahanan;
    }

    public int getPantulan() {
        return pantulan;
    }

    public String getMerk() {
        return merk;
    }

    public void kurangiKetahanan(int jumlah) {
        this.ketahanan -= jumlah;
    }

    public void isiKetahanan(int jumlah) {
        this.ketahanan += jumlah;
    }

    public void infoBolaBasket() {
        System.out.println("Bola Basket " + merk + " | Ketahanan: " + ketahanan + " | Pantulan: " + pantulan);
    }
}