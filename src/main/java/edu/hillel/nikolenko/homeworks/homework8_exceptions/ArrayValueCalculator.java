package edu.hillel.nikolenko.homeworks.homework8_exceptions;

public class ArrayValueCalculator {
    public static void main(String[] args) {
        String[][] correctArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] incorrectArray1 = {{"1", "2", "3", "4"}, {"5", "6", "7"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] incorrectArray2 = {{"1", "2", "3", "4"}, {"a", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] incorrectArray3 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}};

        try {
            System.out.println(doCalc(correctArray));
        } catch (ArraySizeException | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println(doCalc(incorrectArray1));
        } catch (ArraySizeException | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println(doCalc(incorrectArray2));
        } catch (ArraySizeException | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println(doCalc(incorrectArray3));
        } catch (ArraySizeException | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 || array[i].length != 4) throw new ArraySizeException("ArraySizeException: array size doesn't equal 4");
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("ArrayDataException: incorrect array's data in " + i + "-" + j);
                }
            }
        }

        return sum;
    }
}
