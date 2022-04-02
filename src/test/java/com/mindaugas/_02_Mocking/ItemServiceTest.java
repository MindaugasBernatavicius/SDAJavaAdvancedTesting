package com.mindaugas._02_Mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    // ... without mocking:
    // ... - slower - need to call external database
    // ... - external source of error - database might not be available
    // ... - lack of control, or it's not easy to obtain control
    @Test
    public void testGetItemsWhenCalledReturnsAllItemsExistingInRepo(){
        // given
        var itemService = new ItemService(new ItemRepository());

        // when
        var result = itemService.getItems();

        // then
        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testGetItemsWhenCalledReturnsAllItemsExistingInRepoWithMocking(){
        // given
        var mockRepository = Mockito.mock(ItemRepository.class);
        var itemService = new ItemService(mockRepository);
        Mockito.when(mockRepository.getItems()).thenReturn(new ArrayList<>(){{
            add(new Item(5, "Shirt"));
        }});

        // when
        var result = itemService.getItems();

        // then
        Assertions.assertEquals(new ArrayList<>(){{ add(new Item(5, "Shirt")); }}, result);
        Mockito.verify(mockRepository, Mockito.times(1)).getItems();
        // Mockito.verifyNoInteractions(mockRepository);
        Mockito.verifyNoMoreInteractions(mockRepository);
    }

    @Test
    public void testWithArgumentCapture(@Mock ItemRepository itemRepository){
        // given
        var fetcherItemCapture = ArgumentCaptor.forClass(Item.class);
        var itemService = new ItemService(itemRepository);

        // when
        itemService.addItem(new Item(675, "The Batman!"));

        // then
        Mockito.verify(itemRepository).addItem(fetcherItemCapture.capture());
        Assertions.assertEquals("The Batman", fetcherItemCapture.getValue().title);
    }

}
