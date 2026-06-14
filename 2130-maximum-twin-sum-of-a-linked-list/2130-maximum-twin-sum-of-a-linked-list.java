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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode first = head;
        ListNode second = slow;

        ListNode curr = slow;
        ListNode prevs = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prevs;
            prevs = curr;
            curr = next;
        }
        int maxSum = 0;

        ListNode p1 = first;
        ListNode p2 = prevs;

        while (p1 != null && p2 != null) {
            maxSum = Math.max(maxSum, p1.val + p2.val);

            p1 = p1.next;
            p2 = p2.next;
        }
        return maxSum;

    }
}