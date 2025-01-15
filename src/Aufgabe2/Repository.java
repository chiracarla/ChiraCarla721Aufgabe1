package Aufgabe2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository<T extends HasId> {

    private final Map<Integer, T > data = new HashMap<>();



    public void create(T obj) {
        if (data.containsKey(obj.getId())) {
            throw new IllegalArgumentException("Aufgabe2.Object with ID " + obj.getId() + " already exists.");
        }
        data.put(obj.getId(), obj);
    }

    public T read(int id) {
        return data.get(id);
    }

    public void update(T obj) {
        if (!data.containsKey(obj.getId())) {
            throw new IllegalArgumentException("Aufgabe2.Object with ID " + obj.getId() + " does not exist.");
        }
        data.put(obj.getId(), obj);
    }

    public void delete(int id) {
        if (!data.containsKey(id)) {
            throw new IllegalArgumentException("Aufgabe2.Object with ID " + id + " does not exist.");
        }
        data.remove(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(data.values());
    }

}


//import java.util.List;
//
//public interface IRepository<T> {
//    void create(T entity);
//    T read(int id);
//    void update(T entity);
//    void delete(int id);
//    List<T> getAll();
//}
