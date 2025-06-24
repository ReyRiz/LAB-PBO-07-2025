import java.sql.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    String jenisMotor;
    double kapasitasTangki;
    String tipeSuspensi;
    double kecepatan;
    Date servisBerikutnya;
   
    public Motor(String merek, String model, String jenisMotor, double kapasitasTangki, String tipeSuspensi) {
        super(merek, model);
        this.jenisMotor = jenisMotor;
        this.kapasitasTangki = kapasitasTangki;
        this.tipeSuspensi = tipeSuspensi;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    public double hitungPajak() {
        return 150_000;
    }
    
    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }
    
    public boolean mulai() {
        System.out.println("Motor dinyalakan.");
        return true;
    }
    
    public boolean berhenti() {
        System.out.println("Motor dimatikan.");
        return true;
    }
    
    public double getKecepatan() {
        return this.kecepatan; 
    }
    
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
        System.out.println("Kecepatan diatur ke: " + kecepatan + " km/jam");
    }
    
    public boolean periksaKondisi() {
        return true;
    }
    
    public void lakukanService() {
        System.out.println("Service motor telah dilakukan.");
        this.servisBerikutnya = new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000); 
    }
    
    public Date getWaktuServiceBerikutnya() {
        long tigaBulan = 3L * 30 * 24 * 60 * 60 * 1000; // 3 bulan dalam milidetik
        long waktuSekarang = System.currentTimeMillis();
        return new Date(waktuSekarang + tigaBulan);
    }
    
    public double hitungBiayaService() {
        return 200_000; 
    }
}