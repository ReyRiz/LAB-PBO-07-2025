public class suara {
    private String karakter;
    private int volume; 

    public suara() {
        this.karakter = "Lembut";
        this.volume = 5;
    }

    public suara(String karakter, int volume) {
        this.karakter = karakter;
        this.volume = volume;
    }

    public String getDeskripsiSuara() {
        return "Karakter: " + karakter + ", Volume: " + volume;
    }

    public int getVolume() {
        return volume;
    }
}
