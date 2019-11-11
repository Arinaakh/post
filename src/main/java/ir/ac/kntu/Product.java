package ir.ac.kntu;

import java.util.ArrayList;

public class Product {
    private String name ;
    private Client sender ;
    private Client receiver ;
    private Town productTown ;
    private Town from ;
    private Town to ;
    private double weight ;
    private Date sendTime ;
    private Date receiveTime ;
    private SendWay sendWay ;
    private PostWay postWay ;
    private Situation situation ;
    private double price ;

    static ArrayList<Product> products = new ArrayList<>();

    public Product(String name, Client sender, Client receiver, Town productTown, Town from, Town to,
                   double weight, Date sendTime) {
        this.name = name;
        this.sender = sender;
        this.receiver = receiver;
        this.productTown = productTown;
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.sendTime = sendTime;
        products.add(this);
    }

    public void setSendWay(SendWay sendWay) {
        this.sendWay = sendWay;
    }

    public void setPostWay(PostWay postWay) {
        this.postWay = postWay;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public Situation getSituation() {
        return situation;
    }

    public Town getFrom() {
        return from;
    }

    public Town getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    public Client getSender() {
        return sender;
    }

    public SendWay getSendWay() {
        return sendWay;
    }

    public PostWay getPostWay() {
        return postWay;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "->" +
                " | sender= " + sender +
                " | receiver= " + receiver +
                " | productTown= " + productTown +
                " | from= " + from +
                " | to= " + to +
                " | weight= " + weight +
                " | sendTime= " + sendTime +
                " | receiveTime= " + receiveTime +
                " | sendWay= " + sendWay +
                " | postWay= " + postWay +
                " | situation= " + situation +
                " | price= " + price ;
    }
}

enum SendWay {
    AIR ,
    SEA ,
    GROUND
}

enum PostWay {
    NORMAL ,
    CUSTOM
}

enum Situation {
    SENT ,
    UNRECIEVED ,
    RECEIVED
}

