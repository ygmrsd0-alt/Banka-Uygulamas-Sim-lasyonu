package bankaapp;

public class DovizHesabi extends Hesap {

    private String dovizTuru; // USD, EUR
    private double miktar;

    public DovizHesabi(String iban, String dovizTuru, double miktar) {
        super(iban, 0);
        this.dovizTuru = dovizTuru;
        this.miktar = miktar;
    }

    public double getMiktar() {
        return miktar;
    }

    @Override
    public double getTlKarsiligi() {
        double kur;

        switch (dovizTuru) {
            case "USD" -> kur = 50;
            case "EUR" -> kur = 40;
            default -> kur = 0;
        }

        return miktar * kur;
    }

    @Override
    public void hesapOzeti() {
        System.out.println("=== Döviz Hesabı ===");
        System.out.println("IBAN : " + iban);
        System.out.println("Döviz: " + miktar + " " + dovizTuru);
    }
}
