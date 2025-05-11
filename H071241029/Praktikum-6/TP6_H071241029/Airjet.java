package TP6_H071241029;

public class Airjet extends Kendaraan implements IBergerak {
    private int jumlahMesin;
    private double panjangSayap;
    private double kecepatan;
    private boolean berjalan;

    // Constructor yang menerima semua properti
    public Airjet(String merek, String model, int jumlahMesin, double panjangSayap) {
        super(merek, model);
        this.jumlahMesin = jumlahMesin;
        this.panjangSayap = panjangSayap;
        this.kecepatan = 0;
        this.berjalan = false;
    }

    @Override
    public boolean mulai() {
        berjalan = true;
        System.out.println("Airjet dinyalakan dan mulai pemanasan mesin.");
        return true;
    }
    @Override
    public boolean berhenti() {
        berjalan = false;
        kecepatan = 0;
        System.out.println("Airjet dimatikan setelah pendaratan.");
        return true;
    }
    @Override
    public double getKecepatan() {
        return kecepatan;
    }
    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
    @Override
    public double hitungPajak() {
        return jumlahMesin * 200000.0; // misal Rp200.000 per mesin
    }
    @Override
    public String getTipeKendaraan() {
        return "Airjet";
    }

    // Getter & Setter tambahan
    public int getJumlahMesin() {
        return jumlahMesin;
    }
    public void setJumlahMesin(int jumlahMesin) {
        this.jumlahMesin = jumlahMesin;
    }
    public double getPanjangSayap() {
        return panjangSayap;
    }
    public void setPanjangSayap(double panjangSayap) {
        this.panjangSayap = panjangSayap;
    }
}
