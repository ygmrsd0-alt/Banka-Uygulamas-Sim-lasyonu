package bankaapp;

public abstract class Odeme {

    protected String ad;
    protected double tutar;

    public Odeme(String ad, double tutar) {
        this.ad = ad;
        this.tutar = tutar;
    }

    public double getTutar() {
        return tutar;
    }

    public abstract void odemeYap(Hesap hesap);
}
