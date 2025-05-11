import java.util.Calendar;
import java.util.Date;

public class Pesawat extends Kendaraan implements IBergerak {
    private int jumlahMesin;
    private double panjangSayap;
    private double kecepatan;
    private boolean penerbanganDomestik; // true = domestik, false = internasional
    private Date waktuServisTerakhir;

    public Pesawat(String merek, String model) {
        super(merek, model);
    }

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

    public boolean isPenerbanganDomestik() {
        return penerbanganDomestik;
    }

    public void setPenerbanganDomestik(boolean penerbanganDomestik) {
        this.penerbanganDomestik = penerbanganDomestik;
    }

    @Override
    public double hitungPajak() {
        double njkb = 500000000 + (jumlahMesin * 10000000);
        double pajakDasar = 0.01 * njkb;
        double ppn = penerbanganDomestik ? pajakDasar * 0.11 : 0;

        long now = System.currentTimeMillis();
        long lastService = waktuServisTerakhir != null ? waktuServisTerakhir.getTime() : now;
        long selisihHari = (now - lastService) / (1000 * 60 * 60 * 24);
        double dendaServis = selisihHari > 730 ? 5000000 : 0;

        return pajakDasar + ppn + dendaServis;
    }

    @Override
    public String getTipeKendaraan() {
        return "Pesawat";
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

    public boolean periksaKondisi() {
        return true;
    }

    public void lakukanServis() {
        waktuServisTerakhir = new Date();
    }

    public Date getWaktuServisBerikutnya() {
        if (waktuServisTerakhir == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(waktuServisTerakhir);
        cal.add(Calendar.MONTH, 12); // servis tiap 12 bulan
        return cal.getTime();
    }

    public double hitungBiayaServis() {
        return 25000000; // asumsi biaya servis besar
    }
}
