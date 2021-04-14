package com.volleyballshop.products;

public class Shoes extends Items{

    private String sex;


    public Shoes(int size, String model, String color, String destiny, int price, boolean sold, int quantity, String codeQR, String sex) {
        super(size, model, color, destiny,price,sold,quantity,codeQR);
        this.sex = sex;

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
