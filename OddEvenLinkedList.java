/**
 
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

 */

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode evenHead = null, evenTemp = null, oddHead = null, oddTemp = null, temp = head;
        int index = 0;
        while(temp!=null){
            ListNode new_node = new ListNode(temp.val);
            if(index%2 == 0){
                if(evenHead == null){    
                    evenHead = new_node;
                    evenTemp = new_node;
                }else{
                    evenTemp.next = new_node;
                    evenTemp = evenTemp.next;
                }
            } else{
               if(oddHead == null){
                    oddHead = new_node;
                    oddTemp = new_node;
                }else{
                    oddTemp.next = new_node;
                    oddTemp = oddTemp.next;
                } 
            }

            temp= temp.next;
            index++;
        }

        evenTemp.next = oddHead;

        return evenHead;
        
    }
}