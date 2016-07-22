package linkedlist.mergeKSortedLists;

public class MergeKSortedLists {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)	return null;
        ListNode out = null;        
        for(ListNode list : lists)
        	out = mergeThem(out, list);
        return out;
    }
    
	/**
	 * Merge two lists at a time. Then merge another one with the result of previous merge
	 * Time: O(m1+m2+..+mn)
	 * Space: O(m1+m2+..+mn)
	 * @param l1
	 * @param l2
	 * @return
	 */
    private ListNode mergeThem(ListNode l1, ListNode l2){
		if(l1==null)    return l2;
        if(l2==null)    return l1;
        
        ListNode out = null, curr = out;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1!=null && p2!=null){
            ListNode n;
            if(p1.val<=p2.val){
               n = new ListNode(p1.val);
               p1 = p1.next;
            }  
            else{
                n = new ListNode(p2.val);
                p2 = p2.next;
            }                
            
            if(out==null){
                out = n;
                curr = n;
            }   
            else{
                curr.next = n;
                curr = curr.next;
            }
        }
        
        if(p2==null){
            while(p1!=null){
                ListNode n = new ListNode(p1.val);
                curr.next = n;
                curr = curr.next;
                p1 = p1.next;
            }
        }
        
        if(p1==null){
            while(p2!=null){
                ListNode n = new ListNode(p2.val);
                curr.next = n;
                curr = curr.next;
                p2 = p2.next;
            }
        }
        
        return out;
	}

    public void print(ListNode head){
    	while(head!=null){
    		System.out.print(head.val + ", ");
    	}
    	System.out.println();
    }
	public static void main(String[] args) {		

	}

}
