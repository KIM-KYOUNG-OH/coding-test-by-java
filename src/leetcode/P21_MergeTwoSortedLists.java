package leetcode;

public class P21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode current = root;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else if(list1.val > list2.val) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            current.next = list1;
        } else if(list2 != null) {
            current.next = list2;
        }

        return root.next;
    }
}
