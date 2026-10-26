package bankaapp;

public class TrafikOdemesi extends Odeme {

    public TrafikOdemesi(String ad, double tutar) {
        super(ad, tutar);
    }

    @Override
    public void odemeYap(Hesap hesap) {
        if (hesap.bakiyeDusur(tutar)) {
            System.out.println(ad + " ödendi: " + tutar + " TL");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
