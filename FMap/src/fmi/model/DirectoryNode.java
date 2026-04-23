package fmi.model;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class DirectoryNode {

    String name;
    List<FileNode> files;

    public DirectoryNode(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFile(FileNode file) {
        files.add(file);
    }

    public void sortFiles() {
        files.sort((f1, f2) -> {
            int cmp = f1.name.compareTo(f2.name);

            if (cmp != 0) return cmp;

            // ако имената са еднакви → extension DESC
            return f2.extension.compareTo(f1.extension);
        });
    }

    public boolean hasDuplicateNames() {
        Set<String> names = new HashSet<>();

        for (FileNode f : files) {
            if (!names.add(f.name)) {
                return true;
            }
        }
        return false;
    }
}
