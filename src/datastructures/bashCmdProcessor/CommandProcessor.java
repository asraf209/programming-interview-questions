package datastructures.bashCmdProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//The idea is to create a Prefix Tree, where each Node will wither represent a Directory or File
public class CommandProcessor {
	Node root = new Node("root", true);
	Node current = root;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = reader.readLine()) != null) {
			line = line.trim().toLowerCase();
			switch (line) {
				case "quit":
					return;
				case "pwd":
					System.out.println("Hello");
					break;
				default:
					return;
			}
		}
	}
}