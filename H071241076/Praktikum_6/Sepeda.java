import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;
    private boolean mulai;
    private boolean berhenti;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    @Override
    public boolean mulai() {
        mulai = true;
        berhenti = false;
        System.out.println("Mulai mengayuh sepeda.");
        return true;
    }

    @Override
    public boolean berhenti() {
        berhenti = true;
        mulai = false;
        kecepatan = 0;
        System.out.println("Sepeda berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (mulai) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan sepeda disetel ke " + kecepatan + " km/h.");
        } else {
            System.out.println("Kamu harus mulai mengayuh dulu.");
        }
    }

    @Override
    public boolean periksaKondisi() {
        boolean kondisi = ukuranRoda >= 20 && jumlahGear > 0;
        System.out.println("Kondisi sepeda: " + (kondisi ? "Baik" : "Perlu pemeriksaan"));
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis sepeda: cek rantai, pompa ban, dan pelumas gear.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 2);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biaya = 100_000 + jumlahGear * 10_000;
        System.out.println("Biaya servis: " + formatRupiah(biaya));
        return biaya;
    }

    @Override
    public double hitungPajak() {
        System.out.println("Sepeda tidak dikenakan pajak.");
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    private String formatRupiah(double nominal) {
        return NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(nominal);
    }
}
