/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int carry = 0;
        ListNode x = new ListNode(-1);
        ListNode res = x;
        while(l1 != null || l2 !=null)
        {
            int temp =-1;
            if(l1 == null && l2 != null)
            {
                temp = l2.val;
                l2 = l2.next;
            }
            
            else if(l1 != null && l2 == null)
            {
                temp = l1.val;
                l1 = l1.next;
            }
            else
            {
                temp = l1.val + l2.val;
                l1 = l1.next;
                l2=l2.next;
            }
            temp += carry;
            
            carry = temp/10;
            
            x.next = new ListNode(temp%10);
            x = x.next;
            
        }
        if(carry > 0)
        {
            x.next = new ListNode(carry);
            x = x.next;
        }
        return res.next;
    }
}
