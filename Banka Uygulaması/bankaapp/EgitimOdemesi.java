package bankaapp;

public class EgitimOdemesi extends Odeme {

    public EgitimOdemesi(String ad, double tutar) {
        super(ad, tutar);
    }

    @Override
    public void odemeYap(Hesap hesap) {
        if (hesap.bakiyeDusur(tutar)) {
            System.out.println(ad + " için eğitim ödemesi yapıldı: " + tutar + " TL");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
