package ir.ac.kntu;

public class Menu {
    public static void start(){
        System.out.println("1-Create Client"+"\n"+"2-Create Town"+ "\n"+"3-Create Product"+"\n"
                +"4-Edit Client"+"\n"+"5-Edit Town"+"\n"+"6-Send"+"\n"+"7-Show Situation"+"\n"+"8-Show Products"+"\n"
                +"9-Search Client"+"\n"+"10-Search Product"+"\n"+"11-Filter By Send Way"+"\n"
                +"12-Filter By Situation"+"\n"+"13-Filter By Client"+ "\n"+"14-Exit");
    }
    public static void clientPrint(){
        for (int i = 0; i < Client.clients.size() ; i++) {
            System.out.println(String.valueOf(i+1) + "-> " + Client.clients.get(i));
        }
    }
    public static void townPrint(){
        for (int i = 0; i < Town.towns.size() ; i++) {
            System.out.println(String.valueOf(i+1) + "-> " + Town.towns.get(i));
        }
    }
    public static void productPrint(){
        for (int i = 0; i < Product.products.size() ; i++) {
            System.out.println(String.valueOf(i+1) + "-> " + Product.products.get(i).getName());
        }
    }
    public static void send(Date date){
        for (int i = 0; i < Product.products.size(); i++) {
            if(date.isBigger(Product.products.get(i).getSendTime())){
                Product.products.get(i).setSituation(Situation.SENT);
            }
        }
    }
    public static double priceCalculate(Town from, Town to, double weight, SendWay sendWay, PostWay postWay){
        Integer toCord = Integer.parseInt(to.getCoordinates());
        Integer fromCord = Integer.parseInt(from.getCoordinates());
        double price = (Math.abs((toCord - fromCord)*100)) + (weight*1000);
        if(postWay == PostWay.CUSTOM){
            if(sendWay == SendWay.AIR){
                price = price * 4;
            }
            if(sendWay == SendWay.SEA){
                price = price * 3;
            }
        }
        else {
            if(sendWay == SendWay.AIR){
                price = price * 2;
            }
            if(sendWay == SendWay.SEA){
                price = price * 1.5;
            }
        }
        return price;
    }
    public static void searchClient(String name){
        for (int i = 0; i < Client.clients.size(); i++) {
            if(Client.clients.get(i).getName().equals(name)){
                System.out.println(Client.clients.get(i));
            }
        }
    }
    public static void searchProductFrom(String from){
        for (int i = 0; i < Product.products.size(); i++) {
            if(Product.products.get(i).getFrom().getName().equals(from)){
                System.out.println(Product.products.get(i));
            }
        }
    }
    public static void searchProductTo(String to){
        for (int i = 0; i < Product.products.size(); i++) {
            if(Product.products.get(i).getTo().getName().equals(to)){
                System.out.println(Product.products.get(i));
            }
        }
    }
    public static void searchProductSendWay(SendWay sendWay){
        for (int i = 0; i < Product.products.size(); i++) {
            if(Product.products.get(i).getSendWay().equals(sendWay)){
                System.out.println(Product.products.get(i));
            }
        }
    }
    public static void searchProductSituation(Situation situation){
        for (int i = 0; i < Product.products.size(); i++) {
            if(Product.products.get(i).getSituation().equals(situation)){
                System.out.println(Product.products.get(i));
            }
        }
    }
    public static void searchProductClient(String client){
        for (int i = 0; i < Product.products.size(); i++) {
            if(Product.products.get(i).getSender().getName().equals(client)){
                System.out.println(Product.products.get(i));
            }
        }
    }

}
