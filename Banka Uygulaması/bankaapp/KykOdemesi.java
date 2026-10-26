package bankaapp;

public class KykOdemesi extends Odeme {

    private boolean geriOdemeli;

    public KykOdemesi(double tutar, boolean geriOdemeli) {
        super("KYK Ödemesi", tutar);
        this.geriOdemeli = geriOdemeli;
    }

    @Override
    public void odemeYap(Hesap hesap) {
        if (hesap.bakiyeDusur(tutar)) {
            System.out.println(
                geriOdemeli
                ? "KYK geri ödemeli burs ödemesi yapıldı: " + tutar + " TL"
                : "KYK yurt ücreti ödendi: " + tutar + " TL"
            );
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
