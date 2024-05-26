package library;

import items.Item;
import patrons.Patron;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public List<Item> listAvailable() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    @Override
    public List<Item> listBorrowed() {
        List<Item> borrowedItems = new ArrayList<>();
        for (Item item : items) {
            if (item.isBorrowed()) {
                borrowedItems.add(item);
            }
        }
        return borrowedItems;
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
        }
    }
}
