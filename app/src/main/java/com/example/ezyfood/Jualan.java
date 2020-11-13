package com.example.ezyfood;

public class Jualan {
    private Integer pictProduk;
    private String nameProduk;
    private String priceProduk;

    public Jualan(Integer pictProduk, String nameProduk, String priceProduk) {
        this.pictProduk = pictProduk;
        this.nameProduk = nameProduk;
        this.priceProduk = priceProduk;
    }

    public Integer getPictProduk() {
        return pictProduk;
    }

    public void setPictProduk(Integer pictProduk) {
        this.pictProduk = pictProduk;
    }

    public String getNameProduk() {
        return nameProduk;
    }

    public void setNamaProduk(String nameProduk) {
        this.nameProduk = nameProduk;
    }

    public String getPriceProduk() {

        return priceProduk;
    }

    public void setPriceProduk(String priceProduk) {
        this.priceProduk = priceProduk;
    }
}

