import com.volleyballshop.database.DataBase;
import com.volleyballshop.gui.Gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args){

        DataBase database = DataBase.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loginCounter = 0;
        while(true){
            String login, password;

            try {
                System.out.println("Please, enter your login");
                login = reader.readLine();
                System.out.println("Please, enter your password");
                password = reader.readLine();
            }catch(IOException e){
                System.out.println("Data loading failed!!");
                continue;
            }
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
        while(flag) {
            try {
                Gui.showMainMenu();
                switch (reader.readLine()) {
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
                        System.out.println("Enter the code of the selected product which you want to return");
                        String qrCode2 = reader.readLine();
                        //Gui.showAvailableProduct(database.availableProduct(qrCode2));
                        System.out.println("How many pieces do you want to return?");
                        Gui.showBuyProduct(database.returnProduct(qrCode2, Integer.parseInt(reader.readLine())));
                        break;
                    case "4":
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong choice - choose again");
                }
            } catch (IOException e) {
                System.out.println("Error" );
            }
        }




    }
}
