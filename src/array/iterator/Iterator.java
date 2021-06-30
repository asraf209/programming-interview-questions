package array.iterator;

import java.util.NoSuchElementException;

public class Iterator {
	int[][] vector;
	int row, col;
	int rowLen;
	int current;
	
	public Iterator(int[][] vector) {
		this.vector = vector;
		this.rowLen = vector.length;
	}
	
	public boolean hasNext() {
		// Skip empty vector 
		while (row < rowLen && col == vector[row].length) {
			row++;
			col = 0;	// We want to move forward with first element of the next row
		}
		
		return row < rowLen;
	}
	
	public int next(){
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		// Saves current col position before moving to next one.
		// This will be needed for remove() operation
		this.current = col;
		return this.vector[row][col++];
	}
	
	public void remove() {
		// Since we are removing one element, the new updated vector will be 1 length short that the original one
		int[] updatedVector = new int[vector[row].length -1];
		for (int i=0, j=0; i<this.vector[row].length; i++) {
			if (i==current)	continue;
			updatedVector[j++] = vector[row][i];
		}
		
		vector[row] = updatedVector;
		col = current;
	}
	
	public static void main(String[] args) {
		int[][] vector2D = {{},{1, 2, 3},{},{4, 5},{},{},{6,7},{8},{},{},{9},{10}};
		
		// Print Iterator
		Iterator firstIterator = new Iterator(vector2D);
		while(firstIterator.hasNext()) {
			System.out.println(firstIterator.next());
		}
		// Prints: 1 2 3 4 5 6 7 8 9 10
		System.out.println();
		
		// Remove even numbers from the Iterator
		Iterator secondIterator = new Iterator(vector2D);
		while(secondIterator.hasNext()) {
			if (secondIterator.next() % 2 == 0)
				secondIterator.remove();
		}
		
		// Print the vector after removing all even numbers
		Iterator thirdIterator = new Iterator(vector2D);
		while(thirdIterator.hasNext()) {
			System.out.println(thirdIterator.next());
		}
		// Prints: 1 3 5 7 9
	}
}
