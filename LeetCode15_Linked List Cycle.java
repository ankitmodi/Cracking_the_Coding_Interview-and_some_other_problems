/* Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        
        while(true)
        {
            if(a != null && a.next != null && b != null && b.next != null && b.next.next != null)
            {
                a = a.next;
                b = b.next.next;
                
                if(a==null || b==null)
                {
                    return false;
                }
                if(a==b)
                {
                    return true;
                }
            }
            
            else
            {
                return false;
            }
        }
        
    }
}
