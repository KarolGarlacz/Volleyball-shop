package com.volleyballshop.products;

public class Ball extends Item {

    private String material;


    public Ball(int size, String model, String color, String destiny, int price, boolean sold, int quantity, String codeQR, String material) {
        super(size, model, color, destiny,price,sold,quantity,codeQR);

        this.material = material;

    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
