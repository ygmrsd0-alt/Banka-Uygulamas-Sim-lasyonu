package bankaapp;

public class FaturaOdemesi extends Odeme {

    public FaturaOdemesi(String ad, double tutar) {
        super(ad, tutar);
    }

    @Override
    public void odemeYap(Hesap hesap) {
        if (hesap.bakiyeDusur(tutar)) {
            System.out.println(ad + " faturası ödendi: " + tutar + " TL");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
