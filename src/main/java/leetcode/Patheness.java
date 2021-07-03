package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Patheness {

    public static void main(String[] args) {
        System.out.println(isValid("(())[[[]]]"));
    }

    public  static  boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();
        for (char c : characters) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                char p = map.get(c);
                if (stack.isEmpty() || stack.peek() != p) {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();

    }
}
