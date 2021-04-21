package com.volleyballshop.database;

import com.volleyballshop.products.Ball;
import com.volleyballshop.products.Item;
import com.volleyballshop.products.Shoes;
import com.volleyballshop.products.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;


public class DataBase {

    private List<Item> items = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static DataBase instance = new DataBase();


    //private Items[] items = new Items[6];

    public DataBase(){
        this.items.add(new Ball(19, "Molten", "red", "outdoor", 200, false, 0, "111", "leather"));
        this.items.add(new Ball(18, "Mikasa", "white", "intdoor", 300, false, 10, "222", "leather"));
        this.items.add(new Ball(20, "Spalding", "blue", "outdoor", 400, false, 10, "333", "leather"));

        this.items.add(new Shoes(44, "Asics", "white", "indoor", 500, false, 20, "444", "male"));
        this.items.add(new Shoes(46, "Adidas", "yellow", "indoor", 450, false, 20, "555", "female"));
        this.items.add(new Shoes(48, "Nike", "black", "indoor", 600, false, 20, "666", "male"));

        this.users.add(new User("admin", DigestUtils.md5Hex("admin")));
        this.users.add(new User("host", DigestUtils.md5Hex("host")));
    }
    public List<Item> getItems(){

        return items;
    }
    public static DataBase getInstance(){
        if(DataBase.instance == null){
            DataBase.instance = new DataBase();
        }
        return DataBase.instance;
    }

    public boolean availableProduct(String codeQR){
        Item item = findProduct(codeQR);
        if(item != null && item.getQuantity() > 0){

            return true;

        }
        return false;
    }

    public boolean buyProduct(String codeQR, int quantity){
        Item item = findProduct(codeQR);
        if(item != null && item.getQuantity() >= quantity){
            item.setQuantity(item.getQuantity() - quantity);
            if(item != null && item.getQuantity() == 0){
                item.setSold(true);
            return true;
            }
        }
        return false;
    }
    public boolean returnProduct(String codeQR, int quantity){
        Item item = findProduct(codeQR);
        if(item != null && item.getQuantity() >= quantity){
            item.setQuantity(item.getQuantity() + quantity);
            if(item != null && item.getQuantity() > 0){
                item.setSold(false);
                return true;
            }
        }
        return false;
    }

    private Item findProduct(String codeQR) {
        for (Item item : this.items) {
            if (item.getCodeQR().equals(codeQR)) {
                return item;
            }
        }
        return null;
    }

 public boolean confirmation(String login, String password){
     for(User currentUser : this.users){
         if(currentUser.getLogin().equals(login) && currentUser.getPassword().equals(DigestUtils.md5Hex(password))){
             return true;
         }
     }return false;
 }
 public void listUsers(){
     for(User user : this.users){
         System.out.println(user.getLogin() + " - " + user.getPassword());
     }
 }
}
