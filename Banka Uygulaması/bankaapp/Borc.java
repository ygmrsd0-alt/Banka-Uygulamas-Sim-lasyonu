package bankaapp;

public abstract class Borc {

    protected String ad;
    protected double tutar;
    protected boolean odendi;

    public Borc(String ad, double tutar) {
        this.ad = ad;
        this.tutar = tutar;
        this.odendi = false;
    }

    public boolean isOdendi() {
        return odendi;
    }

    public double getTutar() {
        return tutar;
    }

    public String getAd() {
        return ad;
    }

    public void odendiIsaretle() {
        this.odendi = true;
    }
}
