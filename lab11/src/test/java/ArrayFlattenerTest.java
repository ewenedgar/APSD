import org.example.ArrayFlattener;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertArrayEquals;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArray() {
        ArrayFlattener flattener = new ArrayFlattener();
        Integer [][] input = {{1, 3}, {0}, {4, 5, 9}};
        Integer[] expectedOutput = {1, 3, 0, 4, 5, 9};
        Integer [] result = flattener.flattenArray(input);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFlattenArrayWithNullInput() {
        ArrayFlattener flattener = new ArrayFlattener();
        assertNull(flattener.flattenArray(null));
    }

}
