package fmi.main;

import fmi.model.DirectoryNode;
import fmi.model.FileNode;
import fmi.model.Graph;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Graph graph = new Graph();

        int n;
        do {
            System.out.print("N (1-100): ");
            n = Integer.parseInt(sc.nextLine());
        } while (n < 0 || n > 100);

        Set<String> usedNames = new HashSet<>();

        for (int i = 0; i < n; i++) {

            String dirName;

            while (true) {
                System.out.print("Directory name: ");
                dirName = sc.nextLine();

                if (!dirName.matches("\\d+\\.\\d+\\.\\d+")) {
                    System.out.println("Invalid format!");
                    continue;
                }

                if (!usedNames.add(dirName)) {
                    System.out.println("Duplicate directory!");
                    continue;
                }

                break;
            }

            DirectoryNode dir = new DirectoryNode(dirName);

            int fileCount;
            do {
                System.out.print("Files count (0-20): ");
                fileCount = Integer.parseInt(sc.nextLine());
            } while (fileCount < 0 || fileCount > 20);

            for (int j = 0; j < fileCount; j++) {
                String fileName;

                while (true) {
                    System.out.print("File: ");
                    fileName = sc.nextLine();

                    if (!fileName.matches("[A-Z]+\\.[A-Z]+") || fileName.length() > 15) {
                        System.out.println("Invalid file!");
                        continue;
                    }

                    break;
                }

                dir.addFile(new FileNode(fileName));
            }

            graph.addDirectory(dir);
        }

        System.out.println("\n--- BEFORE SORT ---");
        graph.print();

        // сортиране
        graph.sortDirectories();
        for (DirectoryNode d : graph.directories) {
            d.sortFiles();
        }

        System.out.println("\n--- AFTER SORT ---");
        graph.print();

        // задача 3
        System.out.print("\nCheck directory: ");
        String checkDir = sc.nextLine();

        DirectoryNode d = graph.findDirectory(checkDir);
        if (d != null && d.hasDuplicateNames()) {
            System.out.println("Да");
        } else {
            System.out.println("Не");
        }

        // задача 4
        System.out.print("\nSearch file: ");
        String file = sc.nextLine();

        graph.findFile(file);
    }
}
