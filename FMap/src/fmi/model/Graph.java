package fmi.model;

import java.util.*;

public class Graph {

	public List<DirectoryNode> directories;

	public Graph() {
		directories = new ArrayList<>();
	}

	public void addDirectory(DirectoryNode dir) {
		directories.add(dir);
	}

	public void sortDirectories() {
		directories.sort((d1, d2) -> {
			String[] p1 = d1.name.split("\\.");
			String[] p2 = d2.name.split("\\.");

			int y1 = Integer.parseInt(p1[0]);
			int m1 = Integer.parseInt(p1[1]);
			int d1d = Integer.parseInt(p1[2]);

			int y2 = Integer.parseInt(p2[0]);
			int m2 = Integer.parseInt(p2[1]);
			int d2d = Integer.parseInt(p2[2]);

			if (y1 != y2) return y1 - y2;
			if (m1 != m2) return m1 - m2;
			return d1d - d2d;
		});
	}

	public void print() {
		for (DirectoryNode dir : directories) {
			System.out.println(dir.name);
			for (FileNode f : dir.files) {
				System.out.println(f.getFullName());
			}
		}
	}

	public DirectoryNode findDirectory(String name) {
		for (DirectoryNode dir : directories) {
			if (dir.name.equals(name)) {
				return dir;
			}
		}
		return null;
	}

	public void findFile(String fileName) {
		for (DirectoryNode dir : directories) {
			for (FileNode f : dir.files) {
				if (f.getFullName().equals(fileName)) {
					System.out.println(dir.name);
					break;
				}
			}
		}
	}
}
