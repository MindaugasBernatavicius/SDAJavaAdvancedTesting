package com.mindaugas._02_Mocking;

import java.util.Objects;

public class Item {
    public int id;
    public String title;
    public Item(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(title, item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
