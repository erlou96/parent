package leetcode;

/**
 *  19. 删除链表的倒数第n个元素
 *
 *  快慢指针的思路 ，快指针先走n步
 *  然后同时走，直到快指针走到截至位置，那么慢指针的下一个元素则为删除元素
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0; i<n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String name = "zhangsan";
        for (Character c : name.toCharArray()) {
            if(c.equals(' ')) {
                sb.append("%20");
            }
            sb.append(c);
        }
    }
}
