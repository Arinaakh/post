package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class Town {
    private String name ;
    private String Coordinates ;

    static ArrayList<Town> towns = new ArrayList<>();

    public Town(String name, String coordinates) {
        this.name = name;
        this.Coordinates = coordinates;
        towns.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return Coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    @Override
    public String toString() {
        return name + '-' + "Coordinates=" + Coordinates;
    }
}
