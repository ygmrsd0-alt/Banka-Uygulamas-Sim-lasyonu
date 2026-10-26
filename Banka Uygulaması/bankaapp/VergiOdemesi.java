package bankaapp;

public class VergiOdemesi extends Odeme {

    public VergiOdemesi(String ad, double tutar) {
        super(ad, tutar);
    }

    @Override
    public void odemeYap(Hesap hesap) {
        if (hesap.bakiyeDusur(tutar)) {
            System.out.println(ad + " vergisi ödendi: " + tutar + " TL");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
