import java.util.Date;
import java.util.Calendar;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;
    private Date waktuServisTerakhir;

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

    @Override
    public double hitungPajak() {

        //nilai jual kendaraan bermotor
        double njkb = 9500000 + (kapasitasMesin * 120000);
        //pajak kendaraan bermotor
        double pkb = 0.02 * njkb;
        //Sumbangan Wajib Dana Kecelakaan Lalu Lintas Jalan
        double swdkllj = 150000;

        double pajakBahanBakar;
        if (bahanBakar!= null && bahanBakar.equalsIgnoreCase("Solar")) {
            pajakBahanBakar = 250000;
        } else if (bahanBakar != null && bahanBakar.equalsIgnoreCase("Listrik")) {
            pajakBahanBakar = 0;
        } else {
            pajakBahanBakar = 100000;
        }

        double dendaServis = 0;
        if (waktuServisTerakhir != null) {
            long now = System.currentTimeMillis();
            long lastService = waktuServisTerakhir.getTime();
            long selisihHari = (now - lastService) / (1000 * 60 * 60 * 24);
            if (selisihHari > 365) {
                dendaServis = 750000;
            }
        }

        return pkb + swdkllj + pajakBahanBakar + dendaServis;
    }

    @Override
    public String getTipeKendaraan() {
    return "Mobil";
    }

    @Override
    public boolean mulai() {
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
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
    public boolean periksaKondisi() {
        return true;
    }

    @Override
    public void lakukanServis() {
        waktuServisTerakhir = new Date();
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        if (waktuServisTerakhir == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(waktuServisTerakhir);
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 750000;
    }
}
