package com.volleyballshop.products;

public class Balls extends Items{

    private String material;


    public Balls(int size, String model, String color, String destiny, int price, boolean sold, int quantity, String codeQR, String material) {
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
