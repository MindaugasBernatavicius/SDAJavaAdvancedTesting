package com.mindaugas._02_Mocking;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>(){{
            add(new Item(1, "Socks"));
            add(new Item(2, "Pants"));
        }};
    }
    public List<Item> getItems(){
        return items;
    }
    public void addItem(Item item) { this.items.add(item); }
}
