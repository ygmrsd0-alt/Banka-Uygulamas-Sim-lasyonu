package bankaapp;

public class VadeliHesap extends Hesap implements OdemeYapilabilir {


    private int vadeGun;

    public VadeliHesap(String iban, double bakiye, int vadeGun) {
        super(iban, bakiye);
        this.vadeGun = vadeGun;
    }

    @Override
    public void hesapOzeti() {
        System.out.println("=== Vadeli Hesap ===");
        System.out.println("IBAN   : " + iban);
        System.out.println("Bakiye : " + bakiye + " TL");
        System.out.println("Vade   : " + vadeGun + " gün");
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
