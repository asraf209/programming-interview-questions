package datastructures.bashCmdProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//The idea is to create a Prefix Tree, where each Node will wither represent a Directory or File
public class CommandProcessor {
	Node root = new Node("root" /*name*/, true /*isDirectory*/);
	Node current = root;
	
	void currentDirectoryPath() {
		String path = "";
		Node curr = current;
		while(curr != root) {
			path = "/" + curr.name + path;
			curr = curr.parent;
		}
		
		path = "/" + curr.name + path;
		
		System.out.println(path);
	}
	
	void makeDirectory(String name) {
		if (current.child.containsKey(name)) {
			System.out.println("Directory already exists");
			return;
		}
		
		if (name.length() > 100) {
			System.out.println("Invalid directory name");
			return;
		}
		
		Node newNode = new Node(name, true /*isDirectory*/);
		newNode.parent = current;
		current.child.put(name, newNode);
	}
	
	void createFile(String name) {
		if (current.child.containsKey(name)) {
			System.out.println("File already exists");
			return;
		}
		
		if (name.length() > 100) {
			System.out.println("Invalid file name");
			return;
		}
		
		Node newNode = new Node(name, false /*isDirectory*/);
		newNode.parent = current;
		current.child.put(name, newNode);
	}
	
	void changeDirectory(String name) {
		if (name.equals("..")) {
			if (current != root)	current = current.parent;
			return;
		}
		
		if (!current.child.containsKey(name)) {
			System.out.println("Directory not found");
			return;
		}
		
		current = current.child.get(name);
	}
	
	void listContents() {
		for (String fileOrFolder : current.child.keySet()) {
			System.out.println(current.child.get(fileOrFolder).name);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		CommandProcessor cmdProcessor = new CommandProcessor();
		
		while ((line = reader.readLine()) != null) {
			line = line.trim().toLowerCase();
			String[] cmds = line.split(" ");
			
			switch (cmds[0]) {
				case "quit":
					return;
				case "pwd":
					cmdProcessor.currentDirectoryPath();
					break;
				case "mkdir":
					cmdProcessor.makeDirectory(cmds[1]);
					break;
				case "cd":
					cmdProcessor.changeDirectory(cmds[1]);
					break;
				case "ls":
					cmdProcessor.listContents();
					break;
				case "touch":
					cmdProcessor.createFile(cmds[1]);
					break;
				default:
					continue;
			}
		}
	}
}