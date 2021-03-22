package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        int length = 0;
        while (head != null) {
            stack.push(head.val);
            length++;
            head = head.next;
        }
        int[] res = new int[length];
        int i = 0;
        while (!stack.empty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePrint r = new ReversePrint();
        int[] ints = r.reversePrint(new ListNode(1, new ListNode(2)));
        System.out.println(Arrays.toString(ints));
    }
}
