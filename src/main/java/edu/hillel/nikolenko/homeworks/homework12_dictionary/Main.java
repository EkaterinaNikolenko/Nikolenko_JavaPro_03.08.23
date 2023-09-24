package edu.hillel.nikolenko.homeworks.homework12_dictionary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FilePathException {
        String path1 = "/path/to/file";
        String path2 = "/path/to/oneFile";
        String path3 = "/path/to/anotherFiles";

        FileData file1 = new FileData("file.txt", 50, path1);
        FileData file2 = new FileData("firstApp.java", 200, path1);
        FileData file3 = new FileData("photo.jpg", 3000, path1);
        FileData file4 = new FileData("file.doc", 150, path2);
        FileData file5 = new FileData("anotherFile.txt", 100, path3);
        FileData file6 = new FileData("secondApp.java", 2000, path3);

        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(path1, file1);
        fileNavigator.add(path1, file2);
//        fileNavigator.add(path2, file3); -- Exception
        fileNavigator.add(path1, file3);
        fileNavigator.add(path2, file4);
        fileNavigator.add(path3, file5);
        fileNavigator.add(path3, file6);

        System.out.println(fileNavigator.find(path1));
        System.out.println(fileNavigator.filterBySize(150));

        System.out.println(fileNavigator);
        fileNavigator.remove(path2);
        System.out.println(fileNavigator);

        System.out.println(fileNavigator.sortBySize());
    }
}
