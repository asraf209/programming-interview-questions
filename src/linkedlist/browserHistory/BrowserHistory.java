package linkedlist.browserHistory;

public class BrowserHistory {
	class Node{
		String url;
		Node prev;
		Node next;
		
		public Node(String url) {
			this.url = url;
		}
	}
	
	Node head, current;
	
	public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }
    
	// Drop any forward Urls, when we visit a new Url 
    public void visit(String url) {
        Node newNode = new Node(url);
        this.current.next = newNode;
        newNode.prev = this.current;
        this.current = this.current.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && this.current.prev != null) {
        	this.current = this.current.prev;
        	steps--;
        }
        
        return this.current.url;
    }
    
    public String forward(int steps) {
    	while(steps > 0 && this.current.next != null) {
        	this.current = this.current.next;
        	steps--;
        }
    	
    	return this.current.url;
    }
	
	public static void main(String[] args) {
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
		System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
		System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
		System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
		browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
		System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
		System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
		System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
	}
}
