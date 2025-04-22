public class Main {
    public static void main(String[] args) {
        Tim timA = new Tim("Indonesia", "Patrick");
        Tim timB = new Tim("Argentina", "Spongebob");

        PemainBola pemain1 = new PemainBola("Ronaldo", 7, 105, "Penyerang", timA);
        PemainBola pemain2 = new PemainBola("Gullit", 4, 80, "bertahan", timA);
        PemainBola pemain3 = new PemainBola("Maldini", 3, 90, "bertahan", timB);

        timA.tampilInfoTim();
        timB.tampilInfoTim();

        System.out.println();
        pemain1.tampilkanInfoPemain();

        System.out.println();
        pemain1.operBola(pemain2); // satu tim
        pemain2.operBola(pemain3);  // beda tim

        System.out.println();
        pemain1.berduel(pemain2); // duel dengan rekan
        pemain1.berduel(pemain3);
        System.out.println();
        timA.tampilInfoTim();
        timB.tampilInfoTim(); 
    }
}
