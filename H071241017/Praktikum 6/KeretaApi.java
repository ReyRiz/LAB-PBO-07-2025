public class KeretaApi extends Kendaraan implements IBergerak {
    int jumlahGerbong;
    String asal;
    String tujuan;
    double kecepatan;

    public KeretaApi(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahGerbong() {
        return jumlahGerbong;
    }

    public void setJumlahGerbong(int jumlahGerbong) {
        this.jumlahGerbong = jumlahGerbong;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    @Override
    public String getTipeKendaraan() {
        return "Kereta Api";
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
}
