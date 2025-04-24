public class PemainBola {
    private String nama;
    private int nomorPunggung;
    private int ovr; 
    private Tim tim;    // Atribut objek
    private String posisi; //(Penyerang, Gelandang, Bertahan)

    public PemainBola() {
        this.nama = "Tanpa Nama";
        this.nomorPunggung = 0;
        this.ovr = 50;
        this.posisi = "Gelandang";
        this.tim = new Tim();
    }

    public PemainBola(String nama, int nomorPunggung, int ovr, String posisi, Tim tim) {
        this.nama = nama;
        this.nomorPunggung = nomorPunggung;
        this.ovr = ovr;
        this.posisi = posisi;
        this.tim = tim;
    }

    public void tampilkanInfoPemain() {
        System.out.println("Nama Pemain: " + this.nama);
        System.out.println("Nomor Punggung: " + this.nomorPunggung);
        System.out.println("Posisi: " + this.posisi);
        System.out.println("Tim: " + this.tim.getNamaTim());
    }
    


    public void operBola(PemainBola teman) {
        System.out.println(this.nama + "(" + this.nomorPunggung + ") mengoper bola ke " + teman.nama);
        if (this.tim.getNamaTim().equals(teman.tim.getNamaTim())) {
            System.out.println("Operan berhasil! Mereka dari tim yang sama: " + tim.getNamaTim());
        } else {
            System.out.println("Operan gagal! Mereka beda tim.");
        }
    }

    public void berduel(PemainBola lawan) {

        if (this.tim.getNamaTim().equals(lawan.tim.getNamaTim())) {
            System.out.println(this.nama + " menantang duel " + lawan.nama + "!");
            System.out.println("Duel gagal! " + this.nama + " tidak bisa berduel dengan rekan setim.");
            return;
        }

        System.out.println(this.nama + " menantang duel " + lawan.nama + "!");


        if (this.ovr > lawan.ovr) {
            System.out.println(this.nama + " menang duel!");
            if (lawan.posisi.equalsIgnoreCase("Bertahan")) {
                this.tim.tambahSkor();
                System.out.println(this.nama + " mencetak gol!");
            }
        } else if (this.ovr < lawan.ovr) {
            System.out.println(lawan.nama + " menang duel!");
            if (this.posisi.equalsIgnoreCase("Bertahan")) {
                System.out.println(lawan.nama + " mencetak gol!");
            }
        } else {
            System.out.println("Duel imbang!");
        }
    }

    public String getNama() {
        return nama;
    }
    public String getPosisi() {
        return posisi;
    }
}
