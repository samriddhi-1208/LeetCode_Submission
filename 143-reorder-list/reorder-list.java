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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
    //reverse the second half
ListNode prev = null;
ListNode curr= slow.next;
slow.next=null;
while(curr!=null){
    ListNode next = curr.next;
    curr.next = prev;
    prev=curr;
    curr=next;
}
//merge the two halves
ListNode f = head;
ListNode s = prev;
while(s!=null){
    ListNode temp1=f.next;
    ListNode temp2=s.next;
    f.next=s;
    s.next=temp1;

    f=temp1;
    s=temp2;
}

    }
}