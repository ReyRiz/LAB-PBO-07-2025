import java.sql.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    int jumlahPintu;
    double kapasitasMesin;
    int jumlahKursi;
    String bahanBakar;
    double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

   
    public double hitungPajak() {
        return kapasitasMesin * 0.05;
    }

    @Override
    public String getTipeKendaraan() {
        return "mobil";
    }

    public boolean mulai() {
        return true;
    }

    public boolean berhenti() {
        return true;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public boolean periksaKondisi() {
        return true;
    }

    public void lakukanService() {
        System.out.println("SERVIS DULU BRO!");
    }

    public Date getWaktuServiceBerikutnya() {
        long enamBulan = 6L * 30 * 24 * 60 * 60 * 1000; 
        long waktuSekarang = System.currentTimeMillis();
        return new Date(waktuSekarang + enamBulan);
    }

    public double hitungBiayaService() {
        return 500000; 
}
}