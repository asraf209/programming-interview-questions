# Design Browser History
You have a browser of one tab where you start on the <code>homepage</code> and you can visit another <code>url</code>, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

- <code>BrowserHistory(string homepage)</code> Initializes the object with the <code>homepage</code> of the browser.
- <code>void visit(string url)</code> Visits <code>url</code> from the current page. It clears up all the forward history.
- <code>string back(int steps)</code> Move <code>steps</code> back in history. If you can only return <code>x</code> steps in the history and <code>steps > x</code>, you will return only <code>x</code> steps. Return the current <code>url</code> after moving back in history at most <code>steps</code>.
- <code>string forward(int steps)</code> Move <code>steps</code> forward in history. If you can only forward <code>x</code> steps in the history and <code>steps > x</code>, you will forward only <code>x</code> steps. Return the current <code>url</code> after forwarding in history at most <code>steps</code>.

## Examples
Input:

["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"] </br>
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]] </br>

Output:

[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

Explanation:

BrowserHistory browserHistory = new BrowserHistory("leetcode.com"); </br>
browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com" </br>
browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com" </br>
browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com" </br>
browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com" </br>
browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com" </br>
browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com" </br>
browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com" </br>
browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps. </br>
browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com" </br>
browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"