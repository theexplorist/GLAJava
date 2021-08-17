package class32;

public class OddEvenLinkedList {

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
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode evenHead = head.next;
		ListNode oddTemp = head;
		ListNode evenTemp = head.next;

		while (oddTemp != null && oddTemp.next != null && evenTemp != null && evenTemp.next != null) {
			oddTemp.next = oddTemp.next.next;
			oddTemp = oddTemp.next;

			evenTemp.next = evenTemp.next.next;
			evenTemp = evenTemp.next;
		}
		oddTemp.next = evenHead;
		return head;
	}
}
