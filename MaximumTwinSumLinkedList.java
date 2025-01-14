/**

    In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

    For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
    The twin sum is defined as the sum of a node and its twin.

    Given the head of a linked list with even length, return the maximum twin sum of the linked list.

    

    Example 1:
    Input: head = [5,4,2,1]
    Output: 6
    Explanation:
    Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
    There are no other nodes with twins in the linked list.
    Thus, the maximum twin sum of the linked list is 6. 

    Example 2:
    Input: head = [4,2,2,3]
    Output: 7
    Explanation:
    The nodes with twins present in this linked list are:
    - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
    - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
    Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 

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
    public int pairSum(ListNode head) {
       int size = 0;
       ListNode temp = head;
       
       //finding size
       while(temp!= null){
        temp = temp.next;
        size++;
       }
       
       int middle = size/2;
       temp = head;
       //finding middle node
       while(middle-- > 1){
        temp = temp.next;
       }
        ListNode middleHead = temp.next;
        temp.next = null;

        ListNode curr = middleHead, prev= null, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        temp.next = prev;
        temp = temp.next;
        ListNode temp1 = head;

        int result = 0;

        while(temp1 != null && temp !=null){
            int s = temp1.val+temp.val;
            if(s> result){
                result = s; 
            }
            temp1 = temp1.next;
            temp = temp.next;
        }

        return result;
        
    }
}