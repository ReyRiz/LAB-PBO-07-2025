package models;

public class Profile {
    private String namaLengkap;
    private String namaPanggilan;
    private int umur;
    private String hobi;

    public Profile() {}

    public Profile(String namaLengkap, int umur, String hobi, String namaPanggilan) {
        this.namaLengkap = namaLengkap;
        this.umur = umur;
        this.hobi = hobi;
        this.namaPanggilan = namaPanggilan;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public int getUmur() {
        return umur;
    }

    public String getHobi() {
        return hobi;
    }

    public String getNamaPanggilan() {
        return namaPanggilan;
    }
}

