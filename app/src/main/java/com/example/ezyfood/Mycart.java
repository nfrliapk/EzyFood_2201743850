package com.example.ezyfood;

public class Mycart {
    private Integer photoProduk;
    private String namaProduk;
    private String hargaProduk;
    private String quantity;

    public Mycart(Integer photoProduk, String namaProduk, String hargaProduk, String quantity) {
        this.photoProduk = photoProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.quantity = quantity;
    }

    public Integer getPhotoProduk() {
        return photoProduk;
    }

    public void setPictProduk(Integer photoProduk) {
        this.photoProduk = photoProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getQty() {
        return quantity;
    }

    public void setQty(Integer qty) {
        this.quantity = quantity;
    }
}
