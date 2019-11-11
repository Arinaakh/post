package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Client {
    private String name;
    private String nationalID;

    static ArrayList<Client> clients = new ArrayList<>();

    public Client(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        clients.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nationalID, client.nationalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalID);
    }

    @Override
    public String toString() {
        return name + ' ' + '|' + ' ' + "nationalID=" + nationalID ;
    }
}
