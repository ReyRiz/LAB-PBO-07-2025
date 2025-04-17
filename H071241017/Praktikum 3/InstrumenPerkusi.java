public class InstrumenPerkusi {
    private String nama;
    private String jenis;
    private suara suara; 

    public InstrumenPerkusi() {
        this.nama = "Drum Default";
        this.jenis = "Membranofon";
        this.suara = new suara();
    }

    public InstrumenPerkusi(String nama, String jenis, suara suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    public void mainkanInstrumen() {
        System.out.println(nama + " dimainkan! Jenis: " + jenis);
        System.out.println("Suara yang dihasilkan: " + suara.getDeskripsiSuara());
    }

    public void aduSuara(InstrumenPerkusi lain) {
        System.out.println("\nAdu suara antara " + this.nama + " dan " + lain.nama + "!");
        if (this.suara.getVolume() > lain.suara.getVolume()) {
            System.out.println(this.nama + " lebih keras dari " + lain.nama);
        } else if (this.suara.getVolume() < lain.suara.getVolume()) {
            System.out.println(lain.nama + " lebih keras dari " + this.nama);
        } else {
            System.out.println("Keduanya memiliki volume yang sama.");
        }
    }
}
