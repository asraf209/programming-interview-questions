# Heap using PriorityQueue
Make Max/Min Heap using Java's Priority Queue

## Few basics on Priority Queue
### Insertion
  - add(): Inserts the element into the Queue. Throws exception if Queue is full
  - offer(): Inserts the element into the Queue. Returns 'false' if Queue is full
### Removal
  - poll(): Returns and removes the head of the Queue
  - remove(x): Removes the specified element from Queue
### Access
  - peek(): Returns the head of the Queue
  - java.util.Iterator to iterate over the Queue elements
    - `Iterator<Integer> iterate = numbers.iterator();
    while(iterate.hasNext()) {
      System.out.print(iterate.next());
      System.out.print(", ");
      }`
### Other methods
  - contains(x): Searches the Queue for specified element
  - toArray(): Converts Queue to an Array and returns it
  - size()