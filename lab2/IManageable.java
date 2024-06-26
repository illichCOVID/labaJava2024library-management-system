package library;

import items.Item;

import java.util.List;

public interface IManageable {
    void add(Item item);
    void remove(Item item);
    List<Item> listAvailable();
    List<Item> listBorrowed();
}
