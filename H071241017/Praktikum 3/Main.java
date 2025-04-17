public class Main {
    public static void main(String[] args) {
        suara suaraKendang = new suara("asik dan sangat tenang", 7);
        suara suaraSnare = new suara("Tajam dan Nyaring", 9);

        InstrumenPerkusi kendang = new InstrumenPerkusi("Kendang", "Tradisional", suaraKendang);
        InstrumenPerkusi snareDrum = new InstrumenPerkusi("Snare Drum", "Modern", suaraSnare);

        kendang.mainkanInstrumen();
        System.out.println();
        snareDrum.mainkanInstrumen();

        kendang.aduSuara(snareDrum);
    }
}
