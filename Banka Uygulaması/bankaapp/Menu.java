package bankaapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static int anaMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== GameBank Mobil ===");
        System.out.println("1- Hesaplarım");
        System.out.println("2- Para Transferleri");
        System.out.println("3- Varlıklarım");
        System.out.println("4- Ödemeler");
        System.out.println("5- Profil");
        System.out.println("0- Çıkış");
        System.out.print("Seçim: ");
        return sc.nextInt();
    }

    public static int hesapMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1- Hesap Özeti");
        System.out.println("9- Geri");
        System.out.print("Seçim: ");
        return sc.nextInt();
    }

    public static int transferMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1- Havale");
        System.out.println("9- Geri");
        System.out.print("Seçim: ");
        return sc.nextInt();
    }

    public static int odemeMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1- Eğitim Ödemeleri");
        System.out.println("2- Fatura Ödemeleri");
        System.out.println("3- Trafik / Vergi");
        System.out.println("4- Borç Ödemeleri");
        System.out.println("9- Geri");
        return sc.nextInt();
    }

    public static int egitimOdemeMenu() {
        System.out.println("\n=== Eğitim Ödemeleri ===");
        System.out.println("1- Üniversite Harcı");
        System.out.println("2- ÖSYM Sınav Ücreti");
        System.out.println("3- MEB Ödemeleri");
        System.out.println("4- KYK Ödemeleri");
        System.out.println("9- Geri");
        return new Scanner(System.in).nextInt();
    }

    public static int faturaOdemeMenu() {
        System.out.println("\n=== Fatura Ödemeleri ===");
        System.out.println("1- Elektrik");
        System.out.println("2- Su");
        System.out.println("3- Doğalgaz");
        System.out.println("4- Telefon");
        System.out.println("9- Geri");
        return new Scanner(System.in).nextInt();
    }

    public static int trafikVergiMenu() {
        System.out.println("\n=== Trafik / Vergi Ödemeleri ===");
        System.out.println("1- MTV");
        System.out.println("2- Trafik Cezası");
        System.out.println("3- HGS");
        System.out.println("4- Gelir Vergisi");
        System.out.println("5- Tapu Harcı");
        System.out.println("6- Emlak Vergisi");
        System.out.println("7- Pasaport Harcı");
        System.out.println("9- Geri");
        return new Scanner(System.in).nextInt();
    }
    
    public static int varlikMenu() {
        System.out.println("\n1- Varlıklarım");
        System.out.println("2- Borçlarım");
        System.out.println("9- Geri");
        return scanner.nextInt();
    }

    public static int borcMenu() {
        System.out.println("\n=== BORÇLARIM ===");
        System.out.println("1- Borçları Görüntüle");
        System.out.println("9- Geri");
        return scanner.nextInt();
    }

    public static int borcOdemeMenu() {
        System.out.println("\n=== BORÇ ÖDEME ===");
        System.out.println("1- Borç Öde");
        System.out.println("9- Geri");
        return scanner.nextInt();
    }

    public static Hesap hesapSec(Kullanici kullanici) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHesap seçiniz:");
        for (int i = 0; i < kullanici.getHesaplar().size(); i++) {
            Hesap h = kullanici.getHesaplar().get(i);
            System.out.println(
                    (i + 1) + "- "
                    + h.getIban() + " | "
                    + h.getBakiye() + " TL"
            );
        }

        System.out.print("Seçim: ");
        int secim = sc.nextInt();

        return kullanici.getHesaplar().get(secim - 1);
    }

    public static Hesap tlHesapSec(Kullanici kullanici) {

        List<Hesap> tlHesaplar = new ArrayList<>();

        System.out.println("\nÖdeme yapılacak TL hesabı seçiniz:");

        for (int i = 0; i < kullanici.getHesaplar().size(); i++) {

            Hesap h = kullanici.getHesaplar().get(i);

            if (h instanceof OdemeYapilabilir) {
                tlHesaplar.add(h);
                System.out.println(
                        tlHesaplar.size() + "- " + h.getIban()
                        + " | " + h.getTlKarsiligi() + " TL"
                );
            }
        }

        int secim = scanner.nextInt();

        return tlHesaplar.get(secim - 1);
    }

    public static int borcSec(List<Borc> borclar) {

        System.out.println("\nÖdenecek borcu seçiniz:");

        for (int i = 0; i < borclar.size(); i++) {
            Borc b = borclar.get(i);
            System.out.println(
                    (i + 1) + "- " + b.getAd() + " | " + b.getTutar() + " TL"
                    + (b.isOdendi() ? " (Ödendi)" : "")
            );
        }

        return scanner.nextInt();
    }

}
