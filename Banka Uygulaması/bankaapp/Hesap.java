package bankaapp;

public abstract class Hesap {

    protected String iban;
    protected double bakiye;

    public Hesap(String iban, double bakiye) {
        this.iban = iban;
        this.bakiye = bakiye;
    }

    public abstract void hesapOzeti();
    public abstract double getTlKarsiligi();

    public String getIban() {
        return iban;
    }

    public double getBakiye() {
        return bakiye;
    }

    protected boolean bakiyeDusur(double miktar) {
        if (bakiye >= miktar) {
            bakiye -= miktar;
            return true;
        }
        return false;
    }
}
