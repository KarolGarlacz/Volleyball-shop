import com.volleyballshop.database.DataBase;
import com.volleyballshop.gui.Gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {

        DataBase database = new DataBase();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loginCounter = 0;
        while(true){
            System.out.println("Please, enter your login");
            String login = reader.readLine();
            System.out.println("Please, enter your password");
            String password = reader.readLine();

            boolean authResult = database.confirmation(login, password);
            if(authResult){
                break;
            }else{
                System.out.println("Incorrect login details, try again");
                loginCounter++;
            }
            if(loginCounter >=3){
                System.out.println("Error");
                System.exit(0);
            }

        }
        boolean flag = true;
        while(flag){
            Gui.showMainMenu();

            switch(reader.readLine()){
                case "1":
                     Gui.showAllProducts(database.getItems());
                    break;
                case "2":
                    System.out.println("Enter the code of the selected product");
                String qrCode = reader.readLine();
                 Gui.showAvailableProduct(database.availableProduct(qrCode));
                    System.out.println("How many pieces do you want to buy?");
                   Gui.showBuyProduct(database.buyProduct(qrCode, Integer.parseInt(reader.readLine())));
                    break;
                case "3":
                    //kod
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice - choose again");
            }
        }




    }
}
