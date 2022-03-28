package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author 熊乾坤
 * @since 2021-03-28 0:07
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                queue.addFirst(c);
            } else {
                if (c != queue.pollFirst()) {
                    return false;
                }
            }
        }
        return queue.size() == 0;
    }
}
