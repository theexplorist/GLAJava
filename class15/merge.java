/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) {
            return null;
        }
        
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        
        ListNode temp = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            
            temp = temp.next;
        }
        
        if(l1 == null) {
            temp.next = l2;
        }
        
        if(l2 == null) {
            temp.next = l1;
        }
        
        return head.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
		ListNode fast = head;
		for (int i = 1; i <= n; i++) {// kth distance
			fast = fast.next;
		}
        
        if(fast == null) {
            return head.next;
        }
		// slow and fast ko Same Speed se
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
        
        slow.next = slow.next.next;
        
		return head;
    }
}
