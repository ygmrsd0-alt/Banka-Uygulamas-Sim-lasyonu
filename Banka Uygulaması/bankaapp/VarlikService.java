package bankaapp;

import java.util.List;

public class VarlikService {

    public static void toplamVarlikGoster(List<Hesap> hesaplar) {

        double tlToplam = 0;
        double altinTl = 0;
        double dovizTl = 0;

        System.out.println("=== VARLIKLARIM ===");

        for (int i = 0; i < hesaplar.size(); i++) {

            Hesap h = hesaplar.get(i);

            // TL HESAPLAR
            if (h instanceof VadesizHesap || h instanceof VadeliHesap) {
                h.hesapOzeti();
                tlToplam += h.getBakiye();
            }

            // ALTIN HESABI
            if (h instanceof AltinHesabi) {
                AltinHesabi altin = (AltinHesabi) h;
                altin.hesapOzeti();
                altinTl += altin.getTlKarsiligi();
            }

            // DÖVİZ HESABI
            if (h instanceof DovizHesabi) {
                DovizHesabi doviz = (DovizHesabi) h;
                doviz.hesapOzeti();
                dovizTl += doviz.getTlKarsiligi();
            }

            System.out.println("------------------");
        }

        System.out.println("TL Toplam       : " + tlToplam + " TL");
        System.out.println("Altın Karşılığı : " + altinTl + " TL");
        System.out.println("Döviz Karşılığı : " + dovizTl + " TL");
        System.out.println("GENEL TOPLAM    : " + (tlToplam + altinTl + dovizTl) + " TL");
    }

}
