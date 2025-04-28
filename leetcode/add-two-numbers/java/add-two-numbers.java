/**
 * Definition for singly-linked list.
 public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 **/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<>();
        int forNext = 0;
        
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 == null) {
                int l1Num = l1.val;
                sum = l1Num;
                if (forNext != 0) {
                    sum += forNext;
                    forNext = 0;
                }
                l1 = l1.next;
            } else if (l2 != null && l1 == null) {
                int l2Num = l2.val;
                sum = l2Num;
                if (forNext != 0) {
                    sum += forNext;
                    forNext = 0;
                }
                l2 = l2.next;
            } else {
                int l1Num = l1.val;
                int l2Num = l2.val;

                sum = l1Num + l2Num;
                if (forNext != 0) {
                    sum += forNext;
                    forNext = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            }

            if (sum >= 10) {
                forNext = sum / 10;
                sum = sum % 10;
            }
            result.add(sum);
        }

        if (forNext > 0) {
            result.add(forNext);
        }

        ListNode answer = new ListNode();
        ListNode head = answer;
        for (int number : result) {
            answer.next = new ListNode(number);
            answer = answer.next;
        }

        return head.next;
    }
}