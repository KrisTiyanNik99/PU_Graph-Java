package fmi.model;

public class FileNode {

    String name;
    String extension;

    public FileNode(String fullName) {
        String[] parts = fullName.split("\\.");
        this.name = parts[0];
        this.extension = parts[1];
    }

    public String getFullName() {
        return name + "." + extension;
    }
}
