package edu.hillel.nikolenko.homeworks.homework12_dictionary;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> paths = new HashMap<>();

    public void add(String path, FileData file) throws FilePathException {
        if(path == file.getFilePath()) {
            if(!paths.containsKey(path)) {
                paths.put(path, new ArrayList<>());
                paths.get(path).add(file);
            }
            if(!paths.get(path).contains(file)) {
                paths.get(path).add(file);
            }
        } else {
            throw new FilePathException("Wrong path!");
        }
    }

    public List<FileData> find(String path) {
        return paths.get(path);
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> filter = new ArrayList<>();
        for (List<FileData> values : paths.values()) {
            for (FileData value : values) {
                if(value.getFileSizeInBytes() <= size) {
                    filter.add(value);
                }
            }
        }
        return filter;
    }

    public void remove(String path) {
        paths.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortedFiles = new ArrayList<>();
        for (List<FileData> values : paths.values()) {
            for (FileData value : values) {
                sortedFiles.add(value);
            }
        }
        Collections.sort(sortedFiles, Comparator.comparingInt(FileData::getFileSizeInBytes));
        return sortedFiles;
    }

    public Map<String, List<FileData>> getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "paths=" + paths +
                '}';
    }
}
