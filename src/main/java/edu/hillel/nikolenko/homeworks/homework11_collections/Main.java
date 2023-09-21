package edu.hillel.nikolenko.homeworks.homework11_collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("bear");
        animals.add("rat");
        animals.add("dog");
        animals.add("cat");
        animals.add("dog");
        animals.add("zebra");
        animals.add("lion");
        animals.add("elephant");
        animals.add("giraffe");
        animals.add("lion");
        animals.add("snake");
        animals.add("mouse");
        animals.add("mouse");

        System.out.println(countOccurance(animals, "mouse"));

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 2, 5, 7, 10};
        System.out.println(toList(numbers));

        System.out.println(findUnique(toList(numbers)));

        printMap(calcOccurance(animals));
        System.out.println(findOccurance(animals));
    }

    public static int countOccurance(List<String> list, String s) {
        int counter = 0;
        for (String listItem: list) {
            if(listItem == s) counter++;
        }
        return counter;
    }

    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T item : array) {
            list.add(item);
        }
        return list;
    }

    public static <T extends Number> Set<T> findUnique(List<T> list) {
        Set<T> uniqueItems = new HashSet<>(list);
        return uniqueItems;
    }

    public static Map<String, Integer> calcOccurance(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if(map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    public static <T, V> void printMap(Map<T, V> map) {
        for (Map.Entry<T, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Occurrence> findOccurance(List<String> list) {
        Map<String, Integer> map = calcOccurance(list);
        List<Occurrence> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Occurrence(entry.getKey(), entry.getValue()));
        }
        return result;
    }

}
