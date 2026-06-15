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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            len++;
        }
        ListNode ptr = head;
        for(int i  = 0 ; i < len - 1 ; i++){
            ptr = ptr.next;
        }
        ListNode Nodetodel = ptr.next;
        ListNode next = Nodetodel.next;
        ptr.next = next;

        return head;
    }
}