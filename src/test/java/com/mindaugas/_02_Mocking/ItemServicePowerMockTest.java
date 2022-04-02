package com.mindaugas._02_Mocking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ItemRepository.class })
@PowerMockIgnore({"jdk.internal.reflect.*"})
public class ItemServicePowerMockTest {
    @Test
    public void mockingStaticWithPowerMock(){
        // given
        mockStatic(ItemRepository.class);
        when(ItemRepository.add(1, 2)).thenReturn(5);
        when(ItemRepository.add(2, 2)).thenReturn(999);

        // when
        var result = ItemRepository.add(2, 2);

        // then
        Assert.assertEquals(998, result);
    }
}
