public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) { // 注意 String.toCharArray()
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2){
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
        
    }
}

/*
    很多 Class 的 method:
    Stack.isEmpty();
    Stack.push;              压栈，往栈里放一个元素
    Stack.peek();            观察栈顶值，但并不取出来
    Stack.pop();             弹栈，取出栈中最后一个元素
    String.toCharArray();    将字符串转化为一个由单个字符组成的array
    String.valueOf();        返还一个string，但是括号里可以是各种类型: http://www.tutorialspoint.com/java/java_string_valueof.htm
    String.contains();        判断是否包含一个string
*/
