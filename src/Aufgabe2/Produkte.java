package Aufgabe2;

public class Produkte implements HasId{
    private int id;
    private String name;
    private double preis;
    private String herkunftsRegion;

    public Produkte(int id, String name, double preis, String herkunftsRegion) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.herkunftsRegion = herkunftsRegion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getHerkunftsRegion() {
        return herkunftsRegion;
    }

    public void setHerkunftsRegion(String herkunftsRegion) {
        this.herkunftsRegion = herkunftsRegion;
    }


//    @Override
    public int compareTo(Produkte o) {
        if(o.preis > this.preis){
            return 1;
        }
        else if(o.preis < this.preis){
            return -1;
        }
        return 0;
    }
}