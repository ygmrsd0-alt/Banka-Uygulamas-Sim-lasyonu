package bankaapp;

import java.util.ArrayList;
import java.util.List;

public class Kullanici {

    private String ad;
    private String tc;
    private String kartNo;
    private List<Hesap> hesaplar = new ArrayList<>();
    private List<Borc> borclar = new ArrayList<>();

    public Kullanici(String ad, String tc, String kartNo) {
        this.ad = ad;
        this.tc = tc;
        this.kartNo = kartNo;
    }

    public void hesapEkle(Hesap hesap) {
        hesaplar.add(hesap);
    }

    public List<Hesap> getHesaplar() {
        return hesaplar;
    }

    public String getAd() {
        return ad;
    }
    
    public String getTC() {
        return tc;
    }
    
    public String getkartNo() {
        return kartNo;
    }
    
    public void borcEkle(Borc borc) {
        borclar.add(borc);
    }

    public List<Borc> getBorclar() {
        return borclar;
    }
}
