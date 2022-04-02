package com.mindaugas._02_Mocking;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.junit.runner.RunWith;
// import org.mockito.ArgumentCaptor;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.powermock.modules.junit4.PowerMockRunner;
//
// import java.util.ArrayList;
//
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;
//
// @ExtendWith(MockitoExtension.class)
// public class ItemServiceTest {
//
//     // ... without mocking:
//     // ... - slower - need to call external database
//     // ... - external source of error - database might not be available
//     // ... - lack of control, or it's not easy to obtain control
//     @Test
//     @Disabled
//     public void testGetItemsWhenCalledReturnsAllItemsExistingInRepo(){
//         // given
//         var itemService = new ItemService(new ItemRepository());
//
//         // when
//         var result = itemService.getItems();
//
//         // then
//         assertEquals(new ArrayList<>(), result);
//     }
//
//     @Test
//     public void testGetItemsWhenCalledReturnsAllItemsExistingInRepoWithMocking(){
//         // given
//         var mockRepository = mock(ItemRepository.class);
//         var itemService = new ItemService(mockRepository);
//         when(mockRepository.getItems()).thenReturn(new ArrayList<>(){{
//             add(new Item(5, "Shirt"));
//         }});
//
//         // when
//         var result = itemService.getItems();
//
//         // then
//         assertEquals(new ArrayList<>(){{ add(new Item(5, "Shirt")); }}, result);
//         verify(mockRepository, times(1)).getItems();
//         verify(mockRepository, never()).addItem(null);
//         // Mockito.verifyNoInteractions(mockRepository);
//         verifyNoMoreInteractions(mockRepository);
//     }
//
//     @Test
//     public void testWithArgumentCapture(@Mock ItemRepository itemRepository){
//         // given
//         var fetcherItemCapture = ArgumentCaptor.forClass(Item.class);
//         var itemService = new ItemService(itemRepository);
//
//         // when
//         itemService.addItem(new Item(675, "The Batman!"));
//
//         // then
//         verify(itemRepository).addItem(fetcherItemCapture.capture());
//         assertEquals("The Batman", fetcherItemCapture.getValue().title);
//     }
//
//
//     @Test
//     @Disabled
//     public void mockingStatic(){
//         var mockRepo = mock(ItemRepository.class);
//         when(mockRepo.add(1, 2)).thenReturn(3);
//         var itemService = new ItemService(mockRepo);
//     }
// }
