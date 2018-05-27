package reversePolishNotation;

import java.util.LinkedList;

// LeetCode #150 (Reverse Polish Notation).

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

public class ReversePolishNotation {
	
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < tokens.length; i--) {
          switch(tokens[i]) {
            case "+":
              stack.addLast(stack.removeLast() + stack.removeLast());
              break;
            case "-":
              stack.addLast(-stack.removeLast() + stack.removeLast());
              break;
            case "*":
              stack.addLast(stack.removeLast() * stack.removeLast());
              break;
            case "/":
              int a = stack.removeLast();
              int b = stack.removeLast();
              stack.addLast(b / a);
              break;
            default:
              stack.addLast(Integer.parseInt(tokens[i]));
          }
        }
        return stack.removeLast();
    }
    
    // Time complexity is O(n).
    // Space complexity is O(n).
}
