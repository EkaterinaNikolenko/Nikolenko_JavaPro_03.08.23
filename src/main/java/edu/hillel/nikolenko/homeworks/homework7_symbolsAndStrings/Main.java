package edu.hillel.nikolenko.homeworks.homework7_symbolsAndStrings;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(findSymbolOccurance("Hello world", 'l'));
        System.out.println(findWordPosition("Hello World", "lo"));
        System.out.println(stringReverse("Hello"));
        System.out.println(isPalindrome("ERE"));
        guessTheWord();
    }

    public static int findSymbolOccurance(String string, char symbol) {
        char[] charArray = string.toCharArray();
        int counter = 0;
        for (char charSymbol : charArray) {
            if(charSymbol == symbol) counter++;
        }
        return counter;
    }

    public static int findWordPosition(String source, String target) {
        int index = source.indexOf(target);
        return index;
    }

    public static String stringReverse(String string) {
        String reverseString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reverseString += string.charAt(i);
        }
        return reverseString;
    }

    public static boolean isPalindrome(String string) {
        if(string == stringReverse(string).intern()) return true;
        return false;
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String word = words[random.nextInt(26)];
        System.out.println(word);
        String userWord = "";
        StringBuilder res = new StringBuilder("###############");


        do {
            System.out.println("Enter the world: ");
            if(scanner.hasNextLine()) {
                userWord = scanner.nextLine();
                if(userWord.intern() == word) {
                    System.out.println("You win");
                    break;
                } else {
                    int length = Math.min(word.length(), userWord.length());
                    for (int i = 0; i < length - 1; i++) {
                        if(userWord.charAt(i) == word.charAt(i)) {
                            res.setCharAt(i, userWord.charAt(i));
                        }
                    }
                    System.out.println("Almost right: " + res);
                }
            }
        } while(true);
    }
}
