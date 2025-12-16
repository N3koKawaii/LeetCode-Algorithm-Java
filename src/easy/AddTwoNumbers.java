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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode pointer = res;
        int carry = 0;
        int tempSum = 0;

        while(l1 != null && l2 != null){
            tempSum = l1.val + l2.val + carry;
            carry = tempSum / 10;

            pointer.next = new ListNode(tempSum % 10);
            pointer = pointer.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            tempSum = l1.val + carry;
            carry = tempSum / 10;

            pointer.next = new ListNode(tempSum % 10);
            pointer = pointer.next; 

            l1 = l1.next;  
        }

        while(l2 != null){
            tempSum = l2.val + carry;
            carry = tempSum / 10;

            pointer.next = new ListNode(tempSum % 10);
            pointer = pointer.next;

            l2 = l2.next;
        }

        if(carry == 1){
            pointer.next = new ListNode(carry);
        }

        return res.next;
    }
}

## For this question, the first thing came to my mind is that I have to create a result ListNode and a head pointer for it plus a carry if the addition is more than 10. Loop through l1 and l2, add the val of them while l1 and l2 are not NULL. 
Since both of them will not have the same length, so i need to have TWO more while-loop one by one to copy down the value to the result ListNode.
Extra condition at the end, for example:
if l1 = 5 4 6, l2 = 2 7 4, res should be 7 1 1 1
so i also need to check if the carry is 1, if it is, create a new listnode next to the result listnode.


Greater solution:
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}
