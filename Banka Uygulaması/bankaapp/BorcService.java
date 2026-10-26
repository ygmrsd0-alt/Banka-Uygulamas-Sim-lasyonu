package bankaapp;

import java.util.List;

public class BorcService {

    public static void borclariGoster(List<Borc> borclar) {

        System.out.println("=== BORÇ LİSTESİ ===");

        for (int i = 0; i < borclar.size(); i++) {
            Borc b = borclar.get(i);

            System.out.println(
                (i + 1) + "- " + b.getAd()
                + " | " + b.getTutar() + " TL"
                + (b.isOdendi() ? " (Ödendi)" : " (Ödenmedi)")
            );
        }
    }
}
