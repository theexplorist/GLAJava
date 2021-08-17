package class32;

public class ReverseLinkedList {
	
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
	public ListNode reverse(ListNode head) {

		ListNode revList = head;
		ListNode toDo = head.next;
		revList.next = null;

		while (toDo != null) {
			ListNode temp = toDo;
			toDo = toDo.next;
			temp.next = revList;
			revList = temp;
		}

		return revList;
	}
}
