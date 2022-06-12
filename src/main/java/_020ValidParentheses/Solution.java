package _020ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-07 21:55
 **/
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            } else {
                if (deque.isEmpty()) {
                    return false;
                } else {
                    char poll = deque.poll();
                    if ((c == ')' && poll == '(')
                            || (c == ']' && poll == '[')
                            || (c == '}' && poll == '{')) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();
    }
}