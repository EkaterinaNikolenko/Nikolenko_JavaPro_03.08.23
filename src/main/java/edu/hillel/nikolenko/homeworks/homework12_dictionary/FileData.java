package edu.hillel.nikolenko.homeworks.homework12_dictionary;

public class FileData {
    private String fileName;
    private int fileSizeInBytes;
    private String filePath;

    public FileData(String fileName, int fileSizeInBytes, String filePath) {
        this.fileName = fileName;
        this.fileSizeInBytes = fileSizeInBytes;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "fileName='" + fileName;
    }
}
