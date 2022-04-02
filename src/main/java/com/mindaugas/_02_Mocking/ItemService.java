package com.mindaugas._02_Mocking;

import java.util.List;

public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.getItems();
    }

    public void addItem(Item item){
        item.title = item.title.replaceAll("!", "");
        this.itemRepository.addItem(item);
    }
}
