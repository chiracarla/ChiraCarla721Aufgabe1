package Aufgabe2;

import java.util.List;

public class Charaktere implements HasId{
    int id;
    String name;
    List<Produkte> produkte;
    String herkunftsort;

    public Charaktere(int id, String name, List<Produkte> produkte, String herkunftsort) {
        this.id = id;
        this.name = name;
        this.produkte = produkte;
        this.herkunftsort = herkunftsort;
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

    public List<Produkte> getProdukte() {
        return produkte;
    }

    public void setProdukte(List<Produkte> produkte) {
        this.produkte = produkte;
    }

    public String getHerkunftsort() {
        return herkunftsort;
    }

    public void setHerkunftsort(String herkunftsort) {
        this.herkunftsort = herkunftsort;
    }
}
