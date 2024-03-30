import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {
    private Compute compute;
    private MessageQueue mq;

    @Before
    public void setUp() {
        mq = mock(MessageQueue.class);
        compute = new Compute(mq);
    }

    @Test
    public void testCountNumberOfOccurrences_QueueIsEmpty() {
        when(mq.size()).thenReturn(0);
        assertEquals(-1, compute.countNumberOfOccurrences("element"));
    }

    @Test
    public void testCountNumberOfOccurrences_ElementNotPresent() {
        when(mq.size()).thenReturn(2);
        when(mq.contains(anyString())).thenReturn(false);
        assertEquals(0, compute.countNumberOfOccurrences("element"));
    }

    @Test
    public void testCountNumberOfOccurrences_ElementPresentOnce() {
        when(mq.size()).thenReturn(3);
        when(mq.contains("element")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("element");
        when(mq.getAt(1)).thenReturn("anotherElement");
        when(mq.getAt(2)).thenReturn("yetAnotherElement");
        assertEquals(1, compute.countNumberOfOccurrences("element"));
    }

    @Test
    public void testCountNumberOfOccurrences_ElementPresentMultipleTimes() {
        when(mq.size()).thenReturn(4);
        when(mq.contains("element")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("element");
        when(mq.getAt(1)).thenReturn("anotherElement");
        when(mq.getAt(2)).thenReturn("element");
        when(mq.getAt(3)).thenReturn("yetAnotherElement");
        assertEquals(2, compute.countNumberOfOccurrences("element"));
    }
}
