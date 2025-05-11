import java.sql.Date;

public interface IServiceable {
    boolean periksaKondisi();
    void lakukanService();
    Date getWaktuServiceBerikutnya();
    double hitungBiayaService();
    
}
