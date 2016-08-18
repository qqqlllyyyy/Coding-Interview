public class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(minStack.peek(), number));
        }
    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}


/*
    维护两个栈，第二个stack的顶部元素一定是前n个中最小的。理解一下方法:
    每次往stack1中放入元素的时候(假设是第n+1个)，把新元素和stack2的顶部元素(这是前n个中最小的)比较，
    并把较小的放到stack2顶部，就一定是前n+1个元素中最小的。
*/
