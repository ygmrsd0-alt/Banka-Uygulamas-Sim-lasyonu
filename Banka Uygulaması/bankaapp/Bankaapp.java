package bankaapp;

public class Bankaapp {

    public void baslat() {

        Hesap vadesizHesap = new VadesizHesap(
                "TR12 0001 0000 0000",
                15000
        );

        Hesap vadeliHesap = new VadeliHesap(
                "TR34 0002 0000 0000",
                30000,
                90
        );

        Kullanici kullanici = new Kullanici(
                "Yağmur Seda Yılmaz",
                "12345678901",
                "02240224113"
        );

        kullanici.hesapEkle(vadesizHesap);
        kullanici.hesapEkle(vadeliHesap);
        kullanici.hesapEkle(new AltinHesabi("TR99 0003", 200));
        kullanici.hesapEkle(new DovizHesabi("TR88 0004", "USD", 100));
        kullanici.borcEkle(new KrediBorcu(12000));
        kullanici.borcEkle(new KrediKartiBorcu(4500));

        TransferService transferService = new TransferServiceImpl();

        while (true) {
            int secim = Menu.anaMenu();
            if (secim == 0) {
                break;
            }

            switch (secim) {

                case 1 -> {
                    int hm = Menu.hesapMenu();
                    if (hm == 1) {
                        Hesap secilenHesap = Menu.hesapSec(kullanici);
                        secilenHesap.hesapOzeti();
                    }
                }

                case 2 -> {
                    int tm = Menu.transferMenu();

                    if (tm == 1) {

                        String hedefIban = "TR98 0002 0000 0000";
                        double tutar = 2000.0;

                        System.out.println("Alıcı IBAN       : " + hedefIban);
                        System.out.println("Gönderilecek Tutar: " + tutar + " TL");

                        Hesap secilenHesap = Menu.tlHesapSec(kullanici);

                        transferService.havale(
                                secilenHesap,
                                hedefIban,
                                tutar
                        );
                    }
                }

                case 3 -> {

                    while (true) {
                        int vm = Menu.varlikMenu();

                        if (vm == 9) {
                            break;
                        }

                        if (vm == 1) {
                            VarlikService.toplamVarlikGoster(kullanici.getHesaplar());
                        }

                        if (vm == 2) {
                            BorcService.borclariGoster(kullanici.getBorclar());
                        }
                    }

                }

                case 4 -> {

                    while (true) {
                        int om = Menu.odemeMenu();

                        if (om == 9) {
                            break;
                        }

                        switch (om) {

                            case 1 -> {
                                while (true) {
                                    int eo = Menu.egitimOdemeMenu();

                                    if (eo == 9) {
                                        break;
                                    }

                                    Odeme o = null;

                                    switch (eo) {
                                        case 1 ->
                                            o = new EgitimOdemesi("Üniversite Harcı", 2500.0);
                                        case 2 ->
                                            o = new OsymOdemesi(1150.0);
                                        case 3 ->
                                            o = new EgitimOdemesi("MEB Ödemesi", 800.0);
                                        case 4 ->
                                            o = new KykOdemesi(1500.0, false);
                                    }

                                    if (o != null) {
                                        System.out.println("Ödenecek Tutar: " + o.getTutar() + " TL");
                                        Hesap hesap = Menu.tlHesapSec(kullanici);
                                        o.odemeYap(hesap);
                                    }

                                }
                            }

                            case 2 -> {
                                while (true) {
                                    int fo = Menu.faturaOdemeMenu();

                                    if (fo == 9) {
                                        break;
                                    }

                                    Odeme o = null;

                                    switch (fo) {
                                        case 1 ->
                                            o = new FaturaOdemesi("Elektrik", 850.0);
                                        case 2 ->
                                            o = new FaturaOdemesi("Su", 420.0);
                                        case 3 ->
                                            o = new FaturaOdemesi("Doğalgaz", 1200.0);
                                        case 4 ->
                                            o = new FaturaOdemesi("Telefon", 600.0);
                                    }

                                    if (o != null) {
                                        System.out.println("Ödenecek Tutar: " + o.getTutar() + " TL");
                                        Hesap hesap = Menu.tlHesapSec(kullanici);
                                        o.odemeYap(hesap);
                                    }

                                }
                            }

                            case 3 -> {
                                while (true) {
                                    int tv = Menu.trafikVergiMenu();

                                    if (tv == 9) {
                                        break;
                                    }

                                    Odeme o = null;

                                    switch (tv) {
                                        case 1 ->
                                            o = new TrafikOdemesi("MTV", 1800.0);
                                        case 2 ->
                                            o = new TrafikOdemesi("Trafik Cezası", 950.0);
                                        case 3 ->
                                            o = new TrafikOdemesi("HGS", 300.0);
                                        case 4 ->
                                            o = new VergiOdemesi("Gelir Vergisi", 4000.0);
                                        case 5 ->
                                            o = new VergiOdemesi("Tapu Harcı", 7500.0);
                                        case 6 ->
                                            o = new VergiOdemesi("Emlak Vergisi", 650.0);
                                        case 7 ->
                                            o = new VergiOdemesi("Pasaport Harcı", 5600.0);
                                    }

                                    if (o != null) {
                                        System.out.println("Ödenecek Tutar: " + o.getTutar() + " TL");
                                        Hesap hesap = Menu.tlHesapSec(kullanici);
                                        o.odemeYap(hesap);
                                    }

                                }
                            }

                            case 4 -> {

                                int borcSecim = Menu.borcSec(kullanici.getBorclar());
                                if (borcSecim == 9) {
                                    break;
                                }

                                Borc borc = kullanici.getBorclar().get(borcSecim - 1);

                                if (borc.isOdendi()) {
                                    System.out.println("Bu borç zaten ödenmiş.");
                                    break;
                                }

                                System.out.println("Ödenecek Tutar: " + borc.getTutar() + " TL");

                                Hesap hesap = Menu.tlHesapSec(kullanici);

                                if (((OdemeYapilabilir) hesap).bakiyeDusur(borc.getTutar())) {
                                    borc.odendiIsaretle();
                                    System.out.println("Borç ödendi");
                                    BorcService.borclariGoster(kullanici.getBorclar());
                                } else {
                                    System.out.println("Yetersiz bakiye!");
                                }

                                continue;
                            }

                        }
                    }
                }

                case 5 -> {
                    System.out.println("\nKullanıcı: " + kullanici.getAd());
                    System.out.println("TC No: " + kullanici.getTC());
                    System.out.println("Kart Numarası: " + kullanici.getkartNo());
                }
            }

        }

        System.out.println("Uygulamadan çıkış yapıldı.");
    }

    public static void main(String[] args) {
        new Bankaapp().baslat();
    }
}
