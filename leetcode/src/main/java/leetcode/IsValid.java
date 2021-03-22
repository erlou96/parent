package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    public static boolean isValid(String s) {

        HashMap<Character,Character> hashMap = new HashMap();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        Stack stack = new Stack();
        if (hashMap.containsValue(s.charAt(0))) {
            return false;
        }
        char c = ' ';
        for (int i=0;i<s.length();i++){
            c=s.charAt(i);
            if (hashMap.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else {
                if(stack.empty()) {
                    return false;
                }else {
                    if (c == hashMap.get((char)stack.lastElement())) {
                        stack.pop();
                    }else {
                        return false;
                    }
                }

            }

        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(IsValid.isValid("{[]}"));
    }
}
