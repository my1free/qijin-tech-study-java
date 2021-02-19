package tech.qijin.study.quickstart;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isValid(String s) {
        Queue<Character> stack = new LinkedList<Character>();
        for (Character c : s.toCharArray()){
            if (stack.size() == 0 || !isCompared(stack.peek(), c)){
                stack.offer(c);
            }
            if (isCompared(stack.peek(), c)){
                stack.poll();
            }
        }
        return stack.size() == 0;
    }

    private boolean isCompared(char c1, char c2){
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;
        if (c1 == '{' && c2 == '}') return true;
        return false;
    }

}
