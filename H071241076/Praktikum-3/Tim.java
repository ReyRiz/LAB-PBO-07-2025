public class Tim {
    private String namaTim;
    private String pelatih;
    private int skor;

    // Constructor default
    public Tim() {
        this.namaTim = "Belum Ditentukan";
        this.pelatih = "Belum Ditentukan";
        this.skor = 0; 
    }

    // Constructor parameter
    public Tim(String namaTim, String pelatih) {
        this.namaTim = namaTim;
        this.pelatih = pelatih;
        this.skor = 0; 
    }

    public void tambahSkor() {
        this.skor += 1;
        System.out.println("Skor tim " + namaTim + " bertambah! Skor saat ini: " + skor);
    }

    public String getNamaTim() {
        return namaTim;
    }

    public String getPelatih() {
        return pelatih;
    }

    public void tampilInfoTim() {
        System.out.println("Tim: " + namaTim + ", Pelatih: " + pelatih + ", Skor: " + skor);
    }
}
