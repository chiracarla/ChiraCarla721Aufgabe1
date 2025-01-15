package Aufgabe2;

import java.io.Serializable;
/**
 * Interface representing an entity with an ID.
 */
public interface HasId extends Serializable {
    /**
     * gets the ID
     * @return
     */
    int getId();

//    String toFile();
}
