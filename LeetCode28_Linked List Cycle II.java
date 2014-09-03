/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space? */

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
public class Solution 
{
    public ListNode detectCycle(ListNode head) 
    {
        
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
                    return null;
                }
                if(a==b)
                {
                    return NodeIndex(head, a);
                }
            }
            
            else
            {
                return null;
            }
        }
    }
    
    public ListNode NodeIndex(ListNode head, ListNode a)
    {
        ListNode temp = head;
        while(temp!=a)
        {
            temp = temp.next;
            a = a.next;
        }
        return temp;
    }
    
}
