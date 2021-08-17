package class32;

public class ReverseInKPairs {
	
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
	public ListNode reverse(ListNode head, ListNode end) {

		ListNode revList = head;
		ListNode toDo = head.next;
		revList.next = null;

		while (toDo != end) {
			ListNode temp = toDo;
			toDo = toDo.next;
			temp.next = revList;
			revList = temp;
		}

		return revList;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode start = head, end = head;
		for (int i = 0; i < k; i++) {
			if (end == null) {
				return head;
			}
			end = end.next;
		}
		ListNode newHead = reverse(start, end);

		start.next = reverseKGroup(end, k);
		return newHead;
	}
}
