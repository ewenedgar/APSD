import org.example.ArrayFlattenerService;

import java.util.ArrayList;
import java.util.List;

public class MockArrayFlattenerService implements ArrayFlattenerService {
    @Override
    public Integer[] flattenArray(Integer[][] array) {
        // Mock implementation that directly flattens the array
        if (array == null) return null;
        List<Integer> list = new ArrayList<>();
        for (Integer[] subArray : array) {
            for (int num : subArray) {
                list.add(num);
            }
        }
        return list.toArray(new Integer[0]);
    }
}
