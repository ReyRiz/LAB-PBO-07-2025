//class for no 4
class Mahasiswa{
    String nama;
    String nim;
    Alamat alamat;

    String getName(){
        return nama;
    }
    String getNim(){
        return nim;
    }
    String getAlamat(){
        return alamat.jalan + "," + alamat.kota;
    }
}