package Aufgabe2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private Repository<Produkte> prodRepo;
    private Repository<Charaktere> charRepo;

    public Controller(Repository<Produkte> prodRepo, Repository<Charaktere> charRepo) {
        this.prodRepo = prodRepo;
        this.charRepo = charRepo;
    }
    public void createProduct(double price, String name, String herkunft) {
//        Product prod = new Product(price, name, generateProductID(), Seasons.valueOf(season));
        prodRepo.create(new Produkte(generateProductID(), name, price, herkunft));
    }

    public int generateProductID() {
        return prodRepo.getAll().size()+1;
    }

    public void createChar(String name, String herkunft, List<Integer> prodIds) {
        List<Produkte> prodList = new ArrayList<>();
        for (Integer prodId : prodIds) {
            prodList.add(prodRepo.read(prodId));
        }
        charRepo.create(new Charaktere(generateClientID(), name, prodList, herkunft));
    }

    public int generateClientID() {
        return charRepo.getAll().size()+1;
    }

    public Produkte readProduct(int id) {
        return prodRepo.read(id);
    }

    public Charaktere updateChar(int id) {
        return charRepo.read(id);
    }

    public void updateProduct(Produkte product) {
        prodRepo.update(product);
    }

    public void updateChar(Charaktere client) {
        charRepo.update(client);
    }

    public void deleteProduct(int id) {
        prodRepo.delete(id);
    }

    public void deleteChar(int id) {
        charRepo.delete(id);
    }

    public List<Charaktere> filterByHerkunft(String herkunft) {
        List<Charaktere> result = new ArrayList<>();
        for (Charaktere charaktere : charRepo.getAll()) {
            if(charaktere.herkunftsort.equals(herkunft)) {
                result.add(charaktere);
            }
        }
        return result;
    }

    public List<Charaktere> filterByProd(int id) {
        List<Charaktere> result = new ArrayList<>();
        for (Charaktere charaktere : charRepo.getAll()) {
            if(charaktere.produkte.contains(prodRepo.read(id))){
                result.add(charaktere);
            }
        }
        return result;
    }

    public List<Produkte> sortCharProds(int id, String order) {
        sortProducts(charRepo.read(id).getProdukte(), order == "ascending");
        return charRepo.read(id).getProdukte();
    }

    public static void sortProducts(List<Produkte> products, boolean ascending) {
        if (ascending) {
            products.sort(Comparator.comparingDouble(Produkte::getPreis));
        } else {
            products.sort((p1, p2) -> Double.compare(p2.getPreis(), p1.getPreis()));
        }
    }

}
