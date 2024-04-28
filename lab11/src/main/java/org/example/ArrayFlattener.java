package org.example;

public class ArrayFlattener {
    public static void main(String[] args) {
        /*
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] output = flattenArray(input);
        for (int num : output) {
            System.out.print(num + " ");
        }

         */
    }

    public Integer[] flattenArray(Integer [][] array) {
        if (array == null) return null;
        int totalLength = 0;
        for (Integer[] subArray : array) {
            totalLength += subArray.length;
        }

        Integer[] result = new Integer[totalLength];
        Integer currentPosition = 0;

        for (Integer[] subArray : array) {
            for (int item : subArray) {
                result[currentPosition++] = item;
            }
        }

        return result;
    }
/*
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] output = flattenArrayUsingStreams(input);
        Arrays.stream(output).forEach(num -> System.out.print(num + " "));
    }

    public static int[] flattenArrayUsingStreams(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }

 */
}
