package TP3_H071241029;

public class Hunter {
    private String nama;
    private String idHunter;
    private Evol evol;
    private boolean isSecretAgent;

    //constructor default
    public Hunter() {
        this.nama = "Anonim";
        this.idHunter = "H00";
        this.evol = new Evol();
        this.isSecretAgent = false;
    }

    //constructor parameter
    public Hunter(String nama, String idHunter, Evol evol, boolean isSecretAgent) {
        this.nama = nama;
        this.idHunter = idHunter;
        this.evol = evol;
        this.isSecretAgent = isSecretAgent;
    }

    public void memukul(Wanderer monster) {
        int damage = this.evol.getKekuatan();
        System.out.println(nama + " menyerang monster " + monster.getNama() + " dengan kekuatan " + damage);
        monster.diserang(damage);
    }

    public void keroyok(Wanderer monster, Hunter rekan) {
        int damage1 = this.evol.getKekuatan();
        int damage2 = rekan.evol.getKekuatan();
        int totalDamage = damage1 + damage2;

        System.out.println(this.nama + " dan " + rekan.nama + " bersama-sama menyerang " + monster.getNama());
        monster.diserang(totalDamage);
    }

    public void secretAgent() {
        if (isSecretAgent) {
            System.out.println(nama + " adalah agen rahasia dengan ID " + idHunter);
            evol.tampilkanEvol();
        } else {
            System.out.println(nama + " bukan agen rahasia dengan ID " + idHunter);
            evol.tampilkanEvol();
        }
    }
}
