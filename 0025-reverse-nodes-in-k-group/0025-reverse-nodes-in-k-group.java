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

    private ListNode findkthnode(ListNode temp, int k){

        for(int i = 0; i < k - 1 && temp != null ; i++){
            temp = temp.next;
        }
        return temp;

    }

    private ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nn;
        }

        return prev;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode kthnode = findkthnode(temp , k);
            if(kthnode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }
            ListNode nextnode = kthnode.next;
            kthnode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthnode;
            }else{
                prev.next = kthnode;
            }
            prev = temp;
            temp = nextnode;

        }

        return head;


    }
}