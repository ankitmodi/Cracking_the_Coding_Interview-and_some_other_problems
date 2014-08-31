/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode swapPairs(ListNode head) 
    {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode ptr = fake;
        
        while(ptr.next != null && ptr.next.next != null)
        {
            ListNode p = ptr.next;
            ListNode q = ptr.next.next;
            
            //swapping
            p.next = q.next;
            q.next = p;
            
            //changing ptr's next as per new next
            ptr.next = q;
            
            ptr = ptr.next.next ;
        }
        return fake.next;
    }
}
