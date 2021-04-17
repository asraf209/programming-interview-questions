package datastructures.bashCmdProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//The idea is to create a Prefix Tree, where each Node will wither represent a Directory or File
public class CommandProcessor {
	Node root = new Node("root" /*name*/, true /*isDirectory*/);
	Node current = root;
	
	String currentDirectoryPath() {
		return this.currentDirectoryPath(this.current);
	}
	
	String currentDirectoryPath(Node node) {
		String path = "";
		while(node != root) {
			path = "/" + node.name + path;
			node = node.parent;
		}
		
		path = "/" + node.name + path;
		return path;
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
		
		Node tmp = current.child.get(name);
		if (tmp.isDirectory)	current = tmp;
		else System.out.println("Not a directory");
	}
	
	void listContents(String param) {
		if (param==null) {
			// Non-recursive
			for (String fileOrFolder : current.child.keySet()) {
				System.out.println(current.child.get(fileOrFolder).name);
			}
		}
		else if (param.equals("-r")) {
			this.listContentsRecursively(current);
		}
	}
	
	void listContentsRecursively(Node curr) {
		if (curr == null)	return;
				
		// Current folder contents
		for (String fileOrFolder : curr.child.keySet()) {
			System.out.println(this.currentDirectoryPath(curr) + "\t" + curr.child.get(fileOrFolder).name);
		}
		
		// Sub-folder contents
		for (String fileOrFolder : curr.child.keySet()) {
			if (curr.child.get(fileOrFolder).isDirectory) {
				listContentsRecursively(curr.child.get(fileOrFolder)); 
			}
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
					System.out.println(cmdProcessor.currentDirectoryPath());
					break;
				case "mkdir":
					cmdProcessor.makeDirectory(cmds[1]);
					break;
				case "cd":
					cmdProcessor.changeDirectory(cmds[1]);
					break;
				case "ls":
					cmdProcessor.listContents(cmds.length > 1 ? cmds[1] : null);
					break;
				case "touch":
					cmdProcessor.createFile(cmds[1]);
					break;
				default:
					System.out.println("Invalid command");
					continue;
			}
		}
	}
}