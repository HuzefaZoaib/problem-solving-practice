package com.practice;

public class ReverseLinkedList {

	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		
		ReverseLinkedList solution = new ReverseLinkedList();
		ListNode data = solution.prepareData();
		printListNode(data, "Original: ");
		printListNode(solution.reverseList(data), "Reversed: ");
		
		
		RecursionReverseList recSolution = solution.new RecursionReverseList();
		printListNode(recSolution.reverseList(data), "Recursion Reversed: ");
	}
	
	public ListNode prepareData() {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
				
		return ln;
	}
	
	public ListNode reverseList(ListNode head) {
		
		// Idea is that first swap the references of first-two elements, 
		// and retain that information and use to swap it with the next two including 1 itself
		// we will do this by creating three variables prev, cur, next
		
		ListNode prev = null;
		ListNode cur = head;
		ListNode tempNext = null;
		
		while(cur != null) {
			tempNext = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tempNext;
		}
	
		return prev;
	}
		
	// Following is wrong, it is not reversing, instead it is rotating in O(n^2)
	public ListNode reverseList1(ListNode head) {

		// preserve the starting point
		ListNode weStartWith = head;
		while(true) {
			// Iterate till end
			ListNode node = head;
			while(node.next != null) {
				node = node.next;
			}
			
			// After above we will be on the Last Node
			node.next = head;
			
			ListNode newHead = head.next;
			head.next = null;
			head = newHead;
			printListNode(newHead, "");
			
			if(weStartWith == head) {
				break;
			}
		}
		
		return head;
    }
	
	static void printListNode(ListNode head, String msg) {
		
		System.out.print(msg+"[");
		ListNode node = head;
		while(node.next != null) {
			System.out.print(node.val+", ");
			node = node.next;
		}
		System.out.print(node.val+"]\r\n");
	}

	class RecursionReverseList {
		
		public ListNode reverseList(ListNode head) {
		
			// Stopping Condition
			// // The first element that ultimately will become Last, for that head==null will work
			// // head.next == null will help to reach the second last from where it will back track
			if(head == null || head.next == null) {
				return head;
			}
			
			// Recursive Condition
			ListNode rest = reverseList(head.next);
			head.next.next = head;		// not able to understand this part
			
			// In the first iteration it will be on the second element here
			// now we have to swap the references of the first and last one
			//ListNode preserveRestNext = rest.next;
			//rest.next = head;
			
			// preserve head's next
			//preserveHeadNext = head.next;
			
			// Now make the head, the last element
			head.next = null;
			
			// Now the question is who will replace rest's previous.
			// It will be resolved during back tracking
			return rest; 
		}
	}

}
