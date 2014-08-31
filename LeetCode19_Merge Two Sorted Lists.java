/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.*/


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode p = l1; 
        ListNode q = l2;
        
        
        if(l1==null && l2==null)
        {   return l1;}
        if(l1==null && l2!=null)
        {   return l2;}
        if(l1!=null && l2==null)
        {   return l1;}
        
        ListNode res = p;
        
        if(p.val < q.val)
        {
            p = p.next;
        }
        else
        {
            res = q;
            q = q.next;
        }
        
        
        ListNode r = res;
        
        
        while(p != null || q != null)
        {
            if(p == null)
            {
                r.next = q;
                r = r.next;
                q = q.next;
            }
            else if(q == null)
            {
                r.next = p;
                r = r.next;
                p = p.next;
            }
            else if(p.val < q.val)
            {
                r.next = p;
                r = r.next;
                p = p.next;
            }
            else
            {
                r.next = q;
                r = r.next;
                q = q.next;
            }
        }
        return res;
    }
    
   
}
