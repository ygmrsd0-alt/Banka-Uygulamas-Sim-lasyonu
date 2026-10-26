package bankaapp;

public class TransferServiceImpl implements TransferService {

    @Override
    public void havale(Hesap gonderen, String hedefIban, double miktar) {
        if (gonderen.bakiyeDusur(miktar)) {
            System.out.println(miktar + " TL " + hedefIban + " IBAN'ına gönderildi.");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
