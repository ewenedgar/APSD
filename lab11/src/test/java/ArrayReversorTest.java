import org.example.ArrayFlattenerService;
import org.example.ArrayReversor;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {

    @Test
    public void testReverseArray() {
        ArrayFlattenerService mockService = mock(ArrayFlattenerService.class);
        when(mockService.flattenArray(any(Integer[][].class))).thenReturn(new Integer[]{1, 3, 0, 4, 5, 9});

        ArrayReversor reversor = new ArrayReversor(mockService);
        Integer[] result = reversor.reverseArray(new Integer[][]{{1,3}, {0}, {4,5,9}});
        Integer[] expected = {9, 5, 4, 0, 3, 1};

        assertArrayEquals(expected, result);
        verify(mockService).flattenArray(any(Integer[][].class)); // Verify the service was called
    }
    @Test
    public void testReverseArrayWithEmptyInput() {
        ArrayFlattenerService mockService = mock(ArrayFlattenerService.class);
        when(mockService.flattenArray(any(Integer[][].class))).thenReturn(new Integer[0]);

        ArrayReversor reversor = new ArrayReversor(mockService);
        Integer[] result = reversor.reverseArray(new Integer[][]{});
        assertArrayEquals(new Integer[0], result);
        verify(mockService).flattenArray(any(Integer[][].class));
    }
    @Test
    public void testReverseArrayWithNullInput() {
        ArrayFlattenerService mockService = mock(ArrayFlattenerService.class);
        when(mockService.flattenArray(null)).thenReturn(null);

        ArrayReversor reversor = new ArrayReversor(mockService);
        assertNull(reversor.reverseArray(null));
    }
}
