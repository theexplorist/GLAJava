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
    public ListNode reverseList(ListNode head, ListNode tail, ListNode a, ListNode b, ListNode mai) {

		ListNode revList = head;
		ListNode toDo = head.next;

		revList.next = b;
        ListNode nextN = b; 
        ListNode temp = null;
		while (toDo != nextN) {
            
			temp = toDo;
			toDo = toDo.next;

			temp.next = revList;
			revList = temp;
		}

        if(a != null) {
            a.next = revList;
            return mai;
        } else {
            return revList;
        }
        
        
		//return mai;
	}

	public ListNode getAtNode(int nodeNumber, ListNode head) {
		// TODO Auto-generated method stub

		if (head == null) {
			return null;
		}
        
        if(nodeNumber < 1) {
            return null;
        }

		ListNode i = head;
		for (int j = 1; j < nodeNumber; j++) {
			i = i.next;
		}

		return i;
	}
	public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right) {
            return head;
        }
		ListNode nLeft = getAtNode(left, head);
		ListNode nRight = getAtNode(right, head);
        ListNode nLeftm1 = getAtNode(left - 1, head);
        ListNode nRightm1 = getAtNode(right + 1, head);
		//System.out.println(nLeftm1.val);
       // System.out.println(nRightm1.val);
		return reverseList(nLeft, nRight, nLeftm1, nRightm1, head);
	}
}
