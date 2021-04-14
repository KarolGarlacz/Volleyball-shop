package com.volleyballshop.products;

public class Items {
    private int size;
    private String model;
    private String color;
    private String destiny;
    private int price;
    private boolean sold;
    private int quantity;
    private String codeQR;



    public Items(int size, String model, String color, String destiny, int price, boolean sold, int quantity, String codeQR) {
    this.size = size;
    this.model = model;
    this.color = color;
    this.destiny = destiny;
    this.price = price;
    this.sold = false;
    this.quantity = quantity;
    this.codeQR = codeQR;

    }

    public int getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }


}
