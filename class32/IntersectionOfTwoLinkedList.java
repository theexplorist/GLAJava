package class32;

public class IntersectionOfTwoLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public int length(ListNode head) {
        int count = 0;
        
        while(head != null) {
            head = head.next;
            count++;
        }
        
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);
        
        int diff = 0;
        
        ListNode lN1 = null;
        ListNode lN2 = null;
        
        if(l1 >= l2) {
            diff = l1 - l2;
            lN1 = headA;
            lN2 = headB;
        } else {
            diff = l2 - l1;
            
            lN1 = headB;
            lN2 = headA;
        }
        
        while(diff > 0) {
            lN1 = lN1.next;
            diff--;
        }
        while(lN1 != null && lN2 != null) {
            if(lN1 == lN2) {
                return lN1;
            }
            
            lN1 = lN1.next;
            lN2 = lN2.next;
        }
        
        return null;
    }
}
