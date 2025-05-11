import java.sql.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable{
    String jenisSepeda;
    int jumlahGeer;
    int ukuranRoda;
    double kecepatan;

    public Sepeda(String merek, String model, String jenisSepeda, int jumlahGeer, int ukuranRoda) {
        super(merek, model);
        this.jenisSepeda = jenisSepeda;
        this.jumlahGeer = jumlahGeer;
        this.ukuranRoda = ukuranRoda;
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGeer() {
        return jumlahGeer;
    }

    public void setJumlahGeer(int jumlahGeer) {
        this.jumlahGeer = jumlahGeer;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    public double hitungPajak() {
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "sepeda";
    }

    public boolean mulai() {
        System.out.println("Sepeda mulai dikayuh.");
        return true;
    }

    public boolean berhenti() {
        System.out.println("Sepeda berhenti.");
        return true;
    }

    public double getKecepatan() {
        return this.kecepatan; 
    }


    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public boolean periksaKondisi() {
        return true;
    }

    public void lakukanService() {
        System.out.println("Rantai dicek, rem diservis.");
    }

    public Date getWaktuServiceBerikutnya() {
        long satuBulan = 30L * 24 * 60 * 60 * 1000; 
        return new Date(System.currentTimeMillis() + satuBulan);
    }

    public double hitungBiayaService() {
        return 75000;
    }
}