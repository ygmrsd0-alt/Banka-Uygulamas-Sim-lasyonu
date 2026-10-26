package bankaapp;

public class OsymOdemesi extends Odeme {

    public OsymOdemesi(double tutar) {
        super("ÖSYM Sınav Ücreti", tutar);
    }

    @Override
    public void odemeYap(Hesap hesap) {
        if (hesap.bakiyeDusur(tutar)) {
            System.out.println("ÖSYM sınav ücreti ödendi: " + tutar + " TL");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
