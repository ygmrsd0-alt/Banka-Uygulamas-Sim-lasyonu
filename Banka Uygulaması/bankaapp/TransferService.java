package bankaapp;

public interface TransferService {
    void havale(Hesap gonderen, String hedefIban, double miktar);
}

