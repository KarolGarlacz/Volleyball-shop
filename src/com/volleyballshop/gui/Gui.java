package com.volleyballshop.gui;

import com.volleyballshop.products.Ball;
import com.volleyballshop.products.Item;
import com.volleyballshop.products.Shoes;

import java.util.List;

public class Gui {
    static public void showMainMenu(){
        System.out.println("1. Assortment");
        System.out.println("2. Buy");
        System.out.println("3. Return / Complaint");
        System.out.println("4. Exit - thanks for shopping");
    }
    static public void showAllProducts(List<Item> items){
        for(Item item: items){
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
            if(item instanceof Ball){
                Ball ball = (Ball) item;
                sb.append(" Material: ")
                        .append(ball.getMaterial());
            }
            System.out.println(sb.toString());
        }

    }
    static public void showAvailableProduct(boolean AvailableProduct){
        if(AvailableProduct){
         System.out.println("Available product");

       }else{
            System.out.println("try again");
        }
    }
    static public void showBuyProduct(boolean BuyProduct){
        if(BuyProduct){
            System.out.println("You buy products" );

        }else{
            System.out.println("try again");
        }
    }
}
