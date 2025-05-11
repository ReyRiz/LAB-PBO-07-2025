package TP6_H071241029;
import java.util.Date;

public interface IServiceable {
    boolean periksaKondisi();
    void lakukanServis();
    Date getWaktuServisBerikutnya();
    double hitungBiayaServis();
}