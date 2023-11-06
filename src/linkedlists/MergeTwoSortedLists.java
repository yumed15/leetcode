package linkedlists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeTwoSortedLists {
    ListNode append(ListNode head, int new_data) {
        if (head == null) {
            head = new ListNode(new_data);
            return head;
        }

        ListNode node = new ListNode(new_data);
        node.next = null;

        ListNode last = head;
        while (last.next != null)
            last = last.next;
        last.next = node;
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode llist = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                llist = append(llist, l1.val);
                l1 = l1.next;
            } else {
                llist = append(llist, l2.val);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            llist = append(llist, l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            llist = append(llist, l2.val);
            l2 = l2.next;
        }

        return llist;
    }
}
