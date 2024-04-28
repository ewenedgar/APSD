package org.example;
public class ArrayReversor {
    private ArrayFlattenerService flattenerService;

    // Constructor injection for the service
    public ArrayReversor(ArrayFlattenerService service) {
        this.flattenerService = service;
    }

    public Integer[] reverseArray(Integer[][] inputArray) {
        if (inputArray == null) return null;

        Integer[] flattenedArray = flattenerService.flattenArray(inputArray);
        if (flattenedArray == null) return null;

        Integer[] reversedArray = new Integer[flattenedArray.length];
        for (Integer i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }
        return reversedArray;
    }
}
