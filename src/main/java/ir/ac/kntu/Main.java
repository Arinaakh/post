package ir.ac.kntu;

import java.util.Scanner;
import java.lang.Math;

/**
 * @author Arina Khoshraftar
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        int input;

        String name;
        Town town;
        Client client;

        while (!exit){
            Menu.start();
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Enter Name");
                    name = scanner.next();
                    System.out.println("Enter NationalID");
                    String nationalID = scanner.next();
                    boolean b = false;
                    for (int i = 0; i < Client.clients.size(); i++) {
                        if (Client.clients.get(i).getNationalID().equals(nationalID)) {
                            System.out.println("Already exist");
                            b = true;
                            break;
                        }
                    }
                    if(!b){
                        client = new Client(name, nationalID);
                    }
                    System.out.println(Client.clients);
                    break;

                case 2:
                    System.out.println("Enter Name");
                    name = scanner.next();
                    for (int i = 0; i < Town.towns.size(); i++) {
                        if (Town.towns.get(i).getName().equals(name)) {
                            System.out.println("Already exist");
                            break;
                        }
                    }
                    System.out.println("Enter Coordinates");
                    String coordinates = scanner.next();
                    town = new Town(name, coordinates);
                    System.out.println(Town.towns);
                    break;

                case 3:
                    System.out.println("1-Create Product" + "\n" + "2-Change Situation");
                    input = scanner.nextInt();
                    if (input == 1) {
                        System.out.println("Enter Name");
                        name = scanner.next();

                        /////////////

                        if (Client.clients.isEmpty()) {
                            System.out.println("First make a client");
                            break;
                        }

                        System.out.println("Enter Sender");
                        Menu.clientPrint();
                        int senderInput = scanner.nextInt();
                        Client sender = Client.clients.get(senderInput - 1);

                        /////////////

                        System.out.println("Enter Receiver");
                        Menu.clientPrint();
                        int receiverInput = scanner.nextInt();
                        if (receiverInput == senderInput) {
                            System.out.println("Not Possible");
                            break;
                        }
                        Client receiver = Client.clients.get(receiverInput - 1);

                        /////////////

                        if (Town.towns.isEmpty()) {
                            System.out.println("First make town");
                            break;
                        }
                        System.out.println("Enter ProductTown");
                        Menu.townPrint();
                        int productTownInput = scanner.nextInt();
                        Town productTown = Town.towns.get(productTownInput - 1);

                        /////////////

                        System.out.println("Enter source");
                        Menu.townPrint();
                        int sourceInput = scanner.nextInt();
                        Town from = Town.towns.get(sourceInput - 1);

                        /////////////

                        System.out.println("Enter destination");
                        Menu.townPrint();
                        int desInput = scanner.nextInt();
                        Town to = Town.towns.get(desInput - 1);

                        /////////////

                        System.out.println("Enter weight");
                        int weight = scanner.nextInt();

                        /////////////

                        System.out.println("Enter Send Date(day-month-year-hour-minute)");
                        int day = scanner.nextInt();
                        int month = scanner.nextInt();
                        int year = scanner.nextInt();
                        int hour = scanner.nextInt();
                        int minute = scanner.nextInt();
                        Date sendDate = new Date(year, month, day, hour, minute);

                        /////////////

                        Product product = new
                                Product(name, sender, receiver, productTown, from, to, weight, sendDate);

                        /////////////

                        System.out.println("Enter Send Way : (1.Air | 2.Sea | 3.Ground)");

                        int sendWayInput = scanner.nextInt();

                        if(sendWayInput == 1){
                            product.setSendWay(SendWay.AIR);
                        }
                        if(sendWayInput == 2){
                            product.setSendWay(SendWay.SEA);
                        }
                        if(sendWayInput == 3){
                            if (product.getWeight() > 500) {
                                System.out.println("Over 500kg , Not Possible");
                            } else {
                                product.setSendWay(SendWay.GROUND);
                            }
                            break;
                        }

                        /////////////

                        System.out.println("Enter Post Way : (1.Normal | 2.Custom)");

                        int postWayInput = scanner.nextInt();

                        switch (postWayInput) {
                            case 1:
                                product.setPostWay(PostWay.NORMAL);
                                break;
                            case 2:
                                product.setPostWay(PostWay.CUSTOM);
                                break;
                        }

                        product.setPrice(Menu.priceCalculate(product.getFrom(), product.getTo(), product.getWeight(),
                                product.getSendWay(), product.getPostWay()));
                        System.out.println("Price: " + product.getPrice());
                        break;

                    } else {
                        if (Client.clients.isEmpty()) {
                            System.out.println("First make");
                            break;
                        }

                        for (int i = 0; i < Product.products.size(); i++) {
                            System.out.println(String.valueOf(i + 1) + Product.products.get(i));
                        }
                        int product = scanner.nextInt();

                        Product product1 = Product.products.get(product - 1);

                        System.out.println("Enter Situation : (1.Send | 2.Received | 3.Unreceived)");

                        int situation = scanner.nextInt();

                        switch (situation) {
                            case 1:
                                product1.setSituation(Situation.SENT);
                                break;
                            case 2:
                                product1.setSituation(Situation.RECEIVED);
                                break;
                            case 3:
                                product1.setSituation(Situation.UNRECIEVED);
                                break;
                        }
                        break;
                    }

                case 4:
                    Menu.clientPrint();
                    int clientInput = scanner.nextInt();

                    System.out.println("1.Name | 2.NationalID");
                    input = scanner.nextInt();

                    if (input == 1) {
                        System.out.println("Enter New Name");
                        name = scanner.next();
                        Client.clients.get(clientInput - 1).setName(name);
                    } else {
                        System.out.println("Enter New NationalID");
                        nationalID = scanner.next();
                        Client.clients.get(clientInput - 1).setNationalID(nationalID);
                    }
                    break;

                case 5:
                    Menu.townPrint();
                    int townInput = scanner.nextInt();

                    System.out.println("1.Name | 2.Coordinates");
                    input = scanner.nextInt();

                    if (input == 1) {
                        System.out.println("Enter New Name");
                        name = scanner.next();
                        Town.towns.get(townInput - 1).setName(name);
                    } else {
                        System.out.println("Enter New Coordinates");
                        coordinates = scanner.next();
                        Town.towns.get(townInput - 1).setCoordinates(coordinates);
                    }
                    break;

                case 6:
                    System.out.println("Enter Date(day-month-year-hour-minute)");
                    int day = scanner.nextInt();
                    int month = scanner.nextInt();
                    int year = scanner.nextInt();
                    int hour = scanner.nextInt();
                    int minute = scanner.nextInt();
                    Date date = new Date(year, month, day, hour, minute);
                    Menu.send(date);
                    break;

                case 7:
                    Menu.productPrint();
                    int productInput = scanner.nextInt();

                    System.out.println(Product.products.get(productInput-1).getSituation());
                    break;

                case 8:
                    Menu.productPrint();
                    break;

                case 9:
                    System.out.println("Enter Name");
                    name = scanner.next();
                    Menu.searchClient(name);
                    break;

                case 10:
                    System.out.println("By (1.From | 2.To)");
                    input = scanner.nextInt();
                    if(input == 1){
                        System.out.println("Enter Town Name");
                        name = scanner.next();
                        Menu.searchProductFrom(name);
                    }
                    if(input == 2){
                        System.out.println("Enter Town Name");
                        name = scanner.next();
                        Menu.searchProductTo(name);
                    }
                    break;

                case 11:
                    System.out.println("Enter Send Way : (1.Air | 2.Sea | 3.Ground)");

                    int sendWayInput = scanner.nextInt();

                    if(sendWayInput == 1){
                        Menu.searchProductSendWay(SendWay.AIR);
                    }
                    if(sendWayInput == 2){
                        Menu.searchProductSendWay(SendWay.SEA);
                    }
                    if(sendWayInput == 3){
                        Menu.searchProductSendWay(SendWay.GROUND);
                    }
                    break;

                case 12:
                    System.out.println("Enter Situation : (1.Send | 2.Received | 3.Unreceived)");

                    int situation = scanner.nextInt();

                    if(situation == 1){
                        Menu.searchProductSituation(Situation.SENT);
                    }
                    if(situation == 2){
                        Menu.searchProductSituation(Situation.RECEIVED);
                    }
                    if(situation == 3){
                        Menu.searchProductSituation(Situation.UNRECIEVED);
                    }
                    break;

                case 13:
                    System.out.println("Enter Name");
                    name = scanner.next();
                    Menu.searchClient(name);
                    break;

                case 14:
                    return;
            }
        }
    }
}
