package bankaapp;

public class AltinHesabi extends Hesap {

    private double gram; // altın miktarı (gram)

    public AltinHesabi(String iban, double gram) {
        super(iban, 0); // TL bakiyesi kullanılmaz
        this.gram = gram;
    }

    public double getGram() {
        return gram;
    }

    // Güncel altın fiyatı (örnek)
    @Override
    public double getTlKarsiligi() {
        double gramAltinTl = 2500; // SABİT / mock değer
        return gram * gramAltinTl;
    }

    @Override
    public void hesapOzeti() {
        System.out.println("=== Altın Hesabı ===");
        System.out.println("IBAN : " + iban);
        System.out.println("Altın: " + gram + " gr");
    }
}
