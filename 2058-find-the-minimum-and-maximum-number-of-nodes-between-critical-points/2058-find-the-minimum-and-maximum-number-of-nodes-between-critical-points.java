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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        ArrayList<Integer> criticalPoints = new ArrayList<>();
        int count = 2;

        while(curr.next != null) {
            if((prev.val > curr.val && curr.next.val > curr.val) || (prev.val < curr.val && curr.next.val < curr.val)) {
                criticalPoints.add(count);
            }
            count++;
            prev = curr;
            curr = curr.next;
        }

        if(criticalPoints.size() < 2) {
            return new int[] {-1, -1};
        }
        int minDistance = Integer.MAX_VALUE;


        for(int i = 0; i < criticalPoints.size()-1; i++) {
            minDistance = Math.min(minDistance, (criticalPoints.get(i+1) - criticalPoints.get(i)));
        }

        int maxDistance = criticalPoints.get(criticalPoints.size()-1) - criticalPoints.get(0);
        return new int[] {minDistance, maxDistance};
    }
}