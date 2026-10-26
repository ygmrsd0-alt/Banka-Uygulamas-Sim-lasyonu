package bankaapp;

public class VadesizHesap extends Hesap implements OdemeYapilabilir {



    public VadesizHesap(String iban, double bakiye) {
        super(iban, bakiye);
    }

    @Override
    public void hesapOzeti() {
        System.out.println("=== Vadesiz Hesap ===");
        System.out.println("IBAN   : " + iban);
        System.out.println("Bakiye : " + bakiye + " TL");
    }

    @Override
    public boolean bakiyeDusur(double tutar) {
        if (bakiye >= tutar) {
            bakiye -= tutar;
            return true;
        }
        return false;
    }

    @Override
    public double getTlKarsiligi() {
        return bakiye;
    }

}
