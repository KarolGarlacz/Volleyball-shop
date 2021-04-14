package com.volleyballshop.gui;

import com.volleyballshop.products.Balls;
import com.volleyballshop.products.Items;
import com.volleyballshop.products.Shoes;

public class Gui {
    static public void showMainMenu(){
        System.out.println("1. Assortment");
        System.out.println("2. Buy");
        System.out.println("3. Return / Complaint");
        System.out.println("4. Exit - thanks for shopping");
    }
    static void showAllProducts(Items[] items){
        for(Items item: items){
            StringBuilder sb = new StringBuilder();
            sb.append("Size: ")
                    .append(item.getSize())
                    .append(" Model: ")
                    .append(item.getModel())
                    .append(" Color: ")
                    .append(item.getColor())
                    .append(" Destiny: ")
                    .append(item.getDestiny())
                    .append(" Price: ")
                    .append(item.getPrice())
                    .append(" Sold: ")
                    .append(item.isSold())
                    .append(" Quantity: ")
                    .append(item.getQuantity())
                    .append(" Code: " )
                    .append(item.getCodeQR());

            if(item instanceof Shoes){
                Shoes shoe = (Shoes) item;
                sb.append(" Sex: ")
                        .append(shoe.getSex());

            }
            if(item instanceof Balls){
                Balls ball = (Balls) item;
                sb.append(" Material: ")
                        .append(ball.getMaterial());
            }
            System.out.println(sb.toString());
        }

    }
//    public void showBuyProduct(){
//        if(){
//         System.out.println("Available product");
//
//       }else{
//            System.out.println("try again");
//        }
//
//    }
}